import java.util.Scanner;

public class Login extends DbConnection {

    static String stuff_username;
    ManagementManager manager=new ManagementManager();
    CustomerManager customerManager=new CustomerManager();
    StuffManager stuffManager =new StuffManager();


    static String customer_uniqueId;
    static int customer_id;
    public void customerLogin(){
        getCustomers();
        System.out.println("Müşteri kodunu giriniz : ");
        customer_uniqueId=scanner.next();
        for(int i=0;i<customers.size();i++){
            if(customer_uniqueId.equals(customers.get(i).getCustomer_uniqueID()) ){
                System.out.println("Giriş Başarılı..\n");
                System.out.println("Hoş geldin "+ customers.get(i).getCustomer_name());
                customer_id=i;
                customerManager.customerMenu();
            }
        }
    }

   public void stuffLogin(){
        getStuff();

       System.out.println("Personel kullanıcı adınızı giriniz : ");
       stuff_username=scanner.next();
       System.out.println("Personel şifrenizi giriniz : ");
       String stuff_password=scanner.next();

       for(int i=0;i<stuffs.size();i++){

           if(stuff_username.equals(stuffs.get(i).getStuff_username()) && stuff_password.equals(stuffs.get(i).getStuff_password())){

               System.out.println("Hoş geldiniz "+ stuffs.get(i).getStuff_name());
               System.out.println("giriş başarılı");
               updateTime("entrytime",stuff_username);
               stuffManager.stuffRedirect(i);
           }
       }


    }
    public void managementLogin(){
        getManagers();
        System.out.println("Yönetici kullanıcı adınızı giriniz : ");
        String manager_username=scanner.next();
        System.out.println("Yönetici şifrenizi giriniz : ");
        String manager_password=scanner.next();
        for (Management management : managers) {

            if (manager_username.equals(management.getManager_username()) && manager_password.equals(management.getManager_password())) {

                System.out.println("Hoş geldiniz " + management.getManager_name());
                System.out.println("giriş başarılı");
                manager.managerMenu();

            }

        }



    }


}
