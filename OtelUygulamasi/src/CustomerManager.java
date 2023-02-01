
import java.util.Scanner;

public class CustomerManager extends DbConnection {




    public void customerMenu() {
        MainPage mainPage = new MainPage();
        int giris;
        String kontrol = "1";
        System.out.println("Yapmak istediğiniz işlemi giriniz.\n********************************");
        while (kontrol.equals("1")) {
            System.out.println("1-Sipariş Ver \n2-Sipariş Durumu Görüntüle\n3-Oda servisi iste\n4-Gece Kulübüne gir\n***************");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();

            if (giris == 1) {
                kontrol = "";
                foodDisplaying();
                foodChoosing();
            } else if (giris == 2) {
                //getCustomers();

                kontrol = "";
                getOrders(customers.get(Login.customer_id).getCustomer_roomnumber());

            } else if (giris==3) {
                System.out.println("1-Oda Temizliği\n2-Acil Destek\n3-Teknik Destek\n4-Müşteri menüsüne geri dön");
                int secim;
                Scanner scan=new Scanner(System.in);
                secim= scan.nextByte();

                if(secim==1){
                    kontrol = "";
                    Scanner klavye=new Scanner(System.in);
                    System.out.println("Hangi saatler arasında Oda temizliği istersiniz (00:00 şeklinde giriniz):");
                    String saat= klavye.next(); // bu saat veritabanına gönderilecek
                    System.out.println("Talebiniz alınmıştır.");
                }
                else if (secim==2) {
                    kontrol = "";
                    System.out.println("Acil destek geldi burayı düzenlicem");
                }
                else if (secim==3){
                    kontrol = "";
                    System.out.println("Teknik destek yolda");
                }

            }
            else if(giris==4){
                //getCustomers();
                int age=customers.get(Login.customer_id).getCustomer_age();
                if(age<18){
                    kontrol = "";
                    System.out.println("Yaşınız 18 yaşından küçük olduğu için giriş reddedildi");
                }
                else if(age>=18){
                    kontrol = "";
                    System.out.println("Giriş kabul edildi");
                    // buradan gece kulubu işlemlerini içeren bir classa göndersin
                }
            }
            else if (giris==5) {
                mainPage.showLoginChoice();
            }else {
                System.out.println("Hatalı giriş yaptınız !!\n****************");
            }


        }
    }
    public void foodDisplaying() {
        getFoods();
        System.out.println("No    Ürün Adı                    Ürün Ücreti       Ürün Kalorisi      Ürün Kategorisi");
        for (int i=0;i< foods.size();i++) {

                System.out.print(foods.get(i).getFood_id() + " ");
                System.out.print(foods.get(i).getFood_name());
                for (int j = foods.get(i).getFood_name().length(); j < 34; j++) {
                    System.out.print(" ");
                }
                System.out.print(foods.get(i).getFood_price() + "               ");
                System.out.print(foods.get(i).getFood_calories() + "                 ");
                System.out.println(foods.get(i).getFood_category());


        }
    }

    public void foodDisplaying(String category) {
        getFoods();
        System.out.println("No    Ürün Adı                    Ürün Ücreti       Ürün Kalorisi      Ürün Kategorisi");
        for (int i=0;i< foods.size();i++) {
            if (foods.get(i).getFood_category().equalsIgnoreCase(category)){
                System.out.print(foods.get(i).getFood_id() + " ");
                System.out.print(foods.get(i).getFood_name());
                for (int j = foods.get(i).getFood_name().length(); j < 34; j++) {
                    System.out.print(" ");
                }
                System.out.print(foods.get(i).getFood_price() + "               ");
                System.out.print(foods.get(i).getFood_calories() + "                 ");
                System.out.println(foods.get(i).getFood_category());
            }

        }
    }

    public void foodChoosing() {
        getCustomers();
        System.out.print("Lütfen seçmek istediğiniz ürünün numarasını giriniz: ");
        int yemeksecim = scanner.nextInt();

        int ordersRoomnumber ;
        System.out.print("Lütfen kaç porsiyon istediğiniz giriniz: ");
        int porsiyon = scanner.nextInt();
        System.out.println();
        ordersRoomnumber=customers.get(Login.customer_id).getCustomer_roomnumber();
        //  orderAdding(yemeksecim, ordersRoomnumber, porsiyon,foods.get(yemeksecim-1).getFood_name());
        orderAdding(yemeksecim, ordersRoomnumber, porsiyon);
        customerMenu();
    }

}
