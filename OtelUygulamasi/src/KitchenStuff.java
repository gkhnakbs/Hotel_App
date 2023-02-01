public class KitchenStuff extends StuffManager {


    public void menu() {


        int giris;
        boolean control = true;

        System.out.println("Yapmak istediğiniz işlemi giriniz.\n********************************");
        while (control) {
            System.out.println("1-Sipariş Görüntüle \n2-Ürün ekle\n3-Çıkış Yap\n***************");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();

            if (giris == 1) {
                control = false;
                showOrders();
            } else if (giris == 2) {
                control = false;
                addProduct();
            } else if (giris == 3) {
                control = false;
                updateTime("checkout",Login.stuff_username);

            } else {
                System.out.println("Hatalı giriş yaptınız !!\n****************");
            }


        }

    }
    public void showOrders() {
        getOrders(); //?
        String orderStatus;
        /*for (int i = 0; i <orders.size(); i++){
            // gelen siparişler listelenecek
            if ( orders.get(i).getOrder_status()== 0) {
                orderStatus="Sipariş onayı bekleniyor .";
                System.out.print("Sipariş Numarası : "+orders.get(i).getOrder_id()+"   Sipariş Adı : "+orders.get(i).getOrder_name());
                for(int j=orders.get(i).getOrder_name().length();j<34;j++){
                    System.out.print(" ");
                }
                System.out.println("Oda numarası : " +orders.get(i).getOrder_roomnumber()+"   Sipariş durumu : " +orderStatus);
            }
            else if (orders.get(i).getOrder_status()== 1) {
                orderStatus="Sipariş hazırlanıyor...";
                System.out.print("Sipariş Numarası : "+orders.get(i).getOrder_id()+"   Sipariş Adı : "+orders.get(i).getOrder_name());
                for(int j=orders.get(i).getOrder_name().length();j<34;j++){
                    System.out.print(" ");
                }
                System.out.println("Oda numarası : " +orders.get(i).getOrder_roomnumber()+"   Sipariş durumu : " +orderStatus);
            }}
           /* else if (orders.get(i).getOrder_status() == 2){
                orderStatus="Sipariş tamamlandı.";
                System.out.print("Sipariş Numarası : "+orders.get(i).getOrder_id()+"   Sipariş Adı : "+orders.get(i).getOrder_name());
                for(int j=orders.get(i).getOrder_name().length();j<34;j++){
                    System.out.print(" ");
                }
                System.out.println("Oda numarası : " +orders.get(i).getOrder_roomnumber()+"   Sipariş durumu : " +orderStatus);}
        }*/
        boolean control=true;
        while (control) {

            System.out.println("*******************\n1-Sipariş durumunu güncelle\n2-Tamamlanan siparişleri göster\n3-Çıkış yap\n***********");
            System.out.print("Seçim:");
            int choice = scanner.nextInt();
            if (choice == 1) {
                for (int i = 0; i <orders.size(); i++){
                    // gelen siparişler listelenecek
                    if ( orders.get(i).getOrder_status()== 0) {
                        orderStatus="Sipariş onayı bekleniyor .";
                        System.out.print("Sipariş Numarası : "+orders.get(i).getOrder_id()+"   Sipariş Adı : "+orders.get(i).getOrder_name());
                        for(int j=orders.get(i).getOrder_name().length();j<34;j++){
                            System.out.print(" ");
                        }
                        System.out.println("Oda numarası : " +orders.get(i).getOrder_roomnumber()+"   Sipariş durumu : " +orderStatus);
                    }
                    else if (orders.get(i).getOrder_status()== 1) {
                        orderStatus="Sipariş hazırlanıyor...";
                        System.out.print("Sipariş Numarası : "+orders.get(i).getOrder_id()+"   Sipariş Adı : "+orders.get(i).getOrder_name());
                        for(int j=orders.get(i).getOrder_name().length();j<34;j++){
                            System.out.print(" ");
                        }
                        System.out.println("Oda numarası : " +orders.get(i).getOrder_roomnumber()+"   Sipariş durumu : " +orderStatus);
                    }
                }
                System.out.println("Hangi siparişi güncelleyeceksiniz (sipariş numarasını giriniz) :");
                int order_id = scanner.nextInt();
                getOrders();
                for (int a = 0; a < orders.size(); a++) {
                    if (orders.get(a).getOrder_id() == order_id && orders.get(a).getOrder_status() == 0) {
                        System.out.println("1-Hazırlanıyor olarak güncelle\n2-Tamamlandı olarak güncelle");
                        int choice1 = scanner.nextInt();
                        if (choice1 == 1) {
                            updateOrderStatus(1, order_id);

                            break;
                        } else if (choice1 == 2) {
                            updateOrderStatus(2, order_id);
                            break;
                        }
                    } else if (orders.get(a).getOrder_id() == order_id && orders.get(a).getOrder_status() == 1) {
                        updateOrderStatus(2, order_id);

                    }
                }
                System.out.println("Başka bir güncelleme yapmak istiyor musunuz ? (Istiyorsanız 'Evet' veya 'e' tuşlayınız. Çıkmak için herhangi bir tuşa basınız ) ");
                String choice2=scanner.next();
                if (!(choice2.equalsIgnoreCase("evet")||choice2.equalsIgnoreCase("e")))
                    menu();

            } else if (choice == 2) {
                System.out.println("Tamamlanan siparişler:");
                for(int t=0;t<orders.size();t++){
                    if (orders.get(t).getOrder_status() == 2){
                        orderStatus="Sipariş tamamlandı.";
                        System.out.print("Sipariş Numarası : "+orders.get(t).getOrder_id()+"   Sipariş Adı : "+orders.get(t).getOrder_name());
                        for(int j=orders.get(t).getOrder_name().length();j<34;j++){
                            System.out.print(" ");
                        }
                        System.out.println("Oda numarası : " +orders.get(t).getOrder_roomnumber()+"   Sipariş durumu : " +orderStatus);}

                }
                System.out.println("Başka bir güncelleme yapmak istiyor musunuz ? (Istiyorsanız 'Evet' veya 'e' tuşlayınız. Çıkmak için herhangi bir tuşa basınız ) ");
                String choice2=scanner.next();
                if (!(choice2.equalsIgnoreCase("evet")||choice2.equalsIgnoreCase("e")))
                    menu();
            }
            else if (choice == 3) {
                menu();
            }
        }

    }

    public void addProduct() {
        String productName, productCategory;
        int productCalorie, productPrice;
        System.out.println("Ürünün kalorisini giriniz:");
        productCalorie = scanner.nextInt();
        System.out.println("Ürünün fiyatını giriniz:");
        productPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ürün adını giriniz:");
        productName = scanner.nextLine();


        System.out.println("Ürün kategorisini giriniz:");
        productCategory = scanner.nextLine();
        addProduct(productName, productCalorie, productPrice, productCategory);
    }

}
