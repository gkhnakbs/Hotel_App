import java.util.UUID;

public class ManagementManager extends DbConnection {



    int planBinary;
    static String   customerChoice1,name, surname, gender, country;


    static int age,roomnumber,plan;
    public void managerMenu() {

        MainPage mainPage = new MainPage();
        int giris;
        String kontrol = "1";
        System.out.println("Yapmak istediğiniz işlemi giriniz.\n********************************");
        while (kontrol.equals("1")) {
            System.out.println("1-Müşteri kayıt \n2-Personel işlemleri\n3-Yönetim işlemleri\n4-Ana Menüye dön\n***************");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();

            if (giris == 1) {
                kontrol = "";
                saveCustomer();
            } else if (giris == 2) {
                kontrol = "";
                stuffWorkHour("kadirozer");
                saveStuff();
            } else if (giris == 3) {
                kontrol = "";
                System.out.println("Yönetim  işlemleri ");// Düzelt burayı

            } else if (giris == 4) {
                mainPage.showLoginChoice();
            } else {
                System.out.println("Hatalı giriş yaptınız !!\n****************");
            }


        }
    }

    public void saveStuff(){
        System.out.println("Personel ismi giriniz : ");
        scanner.nextLine();

        String stuffName=scanner.nextLine();
        System.out.println("Personel soyadı giriniz : ");
        String stuffSurname=scanner.nextLine();
        System.out.println("Personel yaşı giriniz : ");
        int stuffAge=scanner.nextInt();
        System.out.println("Personel cinsiyeti giriniz : ");
        String stuffGender=scanner.next();
        System.out.println("Personel departmanını giriniz : ");
        scanner.nextLine();
        String stuffDepartment=scanner.nextLine();
        System.out.println("Personelin kullanıcı adını giriniz : ");
        String stuffUserName=scanner.next();
        System.out.println("Personel şifresini giriniz : ");
        String stuffPassword=scanner.next();
        setStuff(stuffName,stuffSurname,stuffAge,stuffGender,stuffUserName,stuffPassword,stuffDepartment);



    }
    // saveCustomerde  bir düzenleme yaptım (Kadir)
    public void saveCustomer() {




        String uniqueID = UUID.randomUUID().toString().substring(0, 8);

        System.out.println("Kaç kişilik oda istiyorsunuz : ");
        int customerChoice=scanner.nextInt();
        showAvailableRooms(customerChoice);
        System.out.println("Hangi odayı istiyorsunuz(oda numarasını girin) : ");
        int room=scanner.nextInt();
        while (true) {
            System.out.print("Müşteri planı giriniz\n1-)Her sey dahil \n2-)Her sey dahil değil \nSeciminiz: ");
            plan = scanner.nextInt();

            if (plan==1) {
                planBinary = 1;

                break;
            } else if (plan==2) {
                planBinary = 0;

                break;
            } else System.out.println("Hatalı giriş yaptınız !!\n**********************");
        }


        for (int i=0;i<customerChoice;i++) {

            System.out.print((i+1)+" . müşterinin Adını giriniz : ");
            scanner.nextLine();
            name = scanner.nextLine();
            System.out.print((i+1)+" . müşterinin Soyadını giriniz : ");
            surname = scanner.next();
            System.out.print((i+1)+" . müşterinin Yaşını giriniz : ");
            age = scanner.nextInt();
            System.out.print((i+1)+" . müşterinin Cinsiyetini giriniz : ");
            gender = scanner.next();
            System.out.print((i+1)+" . müşterinin Ülkesini giriniz : ");
            country = scanner.next();
            System.out.println((i+1)+" . müşterinin ID'si : " + uniqueID);


            updateRoomStatus(1,room);
            setCustomer(name,surname,age,gender,country,uniqueID,room,planBinary);



        }

        }


        public void showAvailableRooms(int customerChoice){
        getRooms();
        for(int i=0;i<rooms.size();i++){
            if (customerChoice==3)
                customerChoice1="3 kişilik";
            else if (customerChoice==2)
                customerChoice1="2 kişilik";
            else if (customerChoice==1)
                customerChoice1="1 kişilik";
    /// kral dairesi eklenecek
            if(rooms.get(i).getRoom_status()==0){
                if(rooms.get(i).getRoom_option().equalsIgnoreCase(customerChoice1)){
                    System.out.print("Oda Numarası : "+rooms.get(i).getRoom_number()+"  Oda durumu : Müsait"+"  Oda Manzarası : "+rooms.get(i).getRoom_view()+"  Oda Fiyatı : "+rooms.get(i).getRoom_price()+"  Oda Seçeneği : "+rooms.get(i).getRoom_option()+"\n");
                }

            }
        }
        }
        public void stuffPayment(String stuffUsername){
            getStuff();


        }


}
