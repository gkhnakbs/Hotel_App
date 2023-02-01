import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class DbConnection extends Abstract1 implements Interface1 {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Stuff> stuffs = new ArrayList<>();
    ArrayList<Management> managers = new ArrayList<>();
    ArrayList<Food> foods = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();

    Connection connection = null, connection1 = null;
    DbHelper dbHelper = new DbHelper();
    ResultSet resultSet, resultSet1;
    static String order_name;
    public void getManagers() {

        Statement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM managers");  // resultSeti nesneye aktarmak için kullanıyoruz

            while (resultSet.next()) {
                managers.add(new Management(
                        resultSet.getString("manager_name"),
                        resultSet.getString("manager_surname"),
                        resultSet.getString("manager_gender"),
                        resultSet.getString("manager_username"),
                        resultSet.getString("manager_password"),
                        resultSet.getInt("manager_age"),
                        resultSet.getInt("manager_id")

                ));

            }


        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getCustomers() {

        Statement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM customers");  // resultSeti nesneye aktarmak için kullanıyoruz

            while (resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getString("customer_name"),
                        resultSet.getString("customer_surname"),
                        resultSet.getString("customer_gender"),
                        resultSet.getString("customer_country"),
                        resultSet.getInt("customer_roomnumber"),
                        resultSet.getInt("customer_age"),
                        resultSet.getString("customer_uniqueID"),
                        resultSet.getInt("customer_plan"),
                        resultSet.getInt("customer_spendamount")
                ));

            }


        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getStuff() {

        Statement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM stuff");  // resultSeti nesneye aktarmak için kullanıyoruz

            while (resultSet.next()) {

                stuffs.add(new Stuff(
                        resultSet.getString("stuff_name"),
                        resultSet.getString("stuff_surname"),
                        resultSet.getString("stuff_gender"),
                        resultSet.getString("stuff_username"),
                        resultSet.getString("stuff_password"),
                        resultSet.getString("stuff_entrytime"),
                        resultSet.getString("stuff_checkout"),
                        resultSet.getString("stuff_department"),
                        resultSet.getInt("stuff_age"),
                        resultSet.getInt("stuff_id"),
                        resultSet.getInt("stuff_workedhour"),
                        resultSet.getDouble("stuff_dailysalary")

                ));

            }

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getFoods() {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM hotelsdb.foods");  // resultSeti nesneye aktarmak için kullanıyoruz

            while (resultSet.next()) {
                foods.add(new Food(
                        resultSet.getInt("food_id"),
                        resultSet.getString("food_name"),
                        resultSet.getInt("food_calorie"),
                        resultSet.getInt("food_price"),
                        resultSet.getString("food_category")
                ));
            }
        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setCustomer(String customer_name, String customer_surname, int customer_age, String customer_gender, String customer_country, String customer_uniqueID, int customer_roomnumber, int customer_plan) {

        PreparedStatement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("insert into customers (customer_name,customer_surname,customer_age,customer_gender,customer_country,customer_uniqueID,customer_roomnumber,customer_plan) values('" + customer_name + "','" + customer_surname + "'," + customer_age + ",'" + customer_gender + "','" + customer_country + "','" + customer_uniqueID + "'," + customer_roomnumber + "," + customer_plan + ")");// resultSeti nesneye aktarmak için kullanıyoruz
            //resultSet = statement.executeQuery("INSERT INTO customers (customer_name,customer_surname,customer_age,customer_gender,customer_country,customer_roomnumber,customer_uniqueID) ('gokhan','akbas',19,'erkek','Turkiye',14,'45612asf')");  // resultSeti nesneye aktarmak için kullanıyoruz
            statement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Müşteri Kaydedildi .");
    }


    public void orderAdding(int order_foodID, int order_roomnumber, int order_count) {
        PreparedStatement statement = null, statement1 = null;
        Statement statement2 = null, statement3 = null;

        for (int i=0;i<foods.size();i++){
            if(foods.get(i).getFood_id()==order_foodID){
               order_name= foods.get(i).getFood_name();
            }
        }
        try {
            connection1 = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection1.prepareStatement("insert into orders (order_foodID,order_roomnumber,order_count,order_name) values(" + order_foodID + "," + order_roomnumber + "," + order_count + ",'"+order_name+"')");// resultSeti nesneye aktarmak için kullanıyoruz
            statement.executeUpdate();

            statement3 = connection1.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet1 = statement3.executeQuery("SELECT * FROM customers WHERE customer_uniqueID='" + Login.customer_uniqueId + "'");  // resultSeti nesneye aktarmak için kullanıyoruz
            int beforeamount = 0;
            if (resultSet1.next()) {
                beforeamount = resultSet1.getInt("customer_spendamount");
            }
            getFoods();
            beforeamount += order_count * (foods.get(order_foodID - 1).getFood_price());

            statement1 = connection1.prepareStatement("UPDATE customers SET customer_spendamount=" + beforeamount + " WHERE customer_uniqueID='" + Login.customer_uniqueId + "'");
            statement1.executeUpdate();
            System.out.println("Sipariş alındı.\n");


        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);

        } finally {
            try {
                statement.close();
                connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void orderAddingForWaiters(int order_foodID,  int order_tablenumber, int order_count,String customerID) {
        PreparedStatement statement = null, statement1 = null;
        Statement statement2 = null, statement3 = null;
        for (int i=0;i<foods.size();i++){
            if(foods.get(i).getFood_id()==order_foodID){
                order_name= foods.get(i).getFood_name();
            }
        }
        try {
            connection1 = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection1.prepareStatement("insert into orders (order_foodID,order_tablenumber,order_count,order_name) values(" + order_foodID + "," + order_tablenumber + "," + order_count + ",'" + order_name + "')");// resultSeti nesneye aktarmak için kullanıyoruz
            statement.executeUpdate();

            statement3 = connection1.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet1 = statement3.executeQuery("SELECT * FROM customers WHERE customer_uniqueID='" + customerID + "'");  // resultSeti nesneye aktarmak için kullanıyoruz
            int beforeamount = 0;
            if (resultSet1.next()) {
                beforeamount = resultSet1.getInt("customer_spendamount");
            }
            getFoods();
            beforeamount += order_count * (foods.get(order_foodID - 1).getFood_price());

            statement1 = connection1.prepareStatement("UPDATE customers SET customer_spendamount=" + beforeamount + " WHERE customer_uniqueID='" + customerID + "'");
            statement1.executeUpdate();
            System.out.println("Sipariş alındı.\n");


        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);

        } finally {
            try {
                statement.close();
                connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // overloading
    public void getOrders(int roomnumber) {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM hotelsdb.orders WHERE order_roomnumber=" + roomnumber);  // resultSeti nesneye aktarmak için kullanıyoruz


            while (resultSet.next()) {

                if (resultSet.getInt("order_status") == 0) {
                    System.out.print(resultSet.getInt("order_count") + " porsiyon ");
                    System.out.print(resultSet.getString("order_name"));
                    System.out.println(" - Sipariş onayı bekleniyor.\n");

                } else if (resultSet.getInt("order_status") == 1) {
                    System.out.print(resultSet.getInt("order_count") + " porsiyon ");
                    System.out.print(resultSet.getString("order_name"));
                    System.out.println(" - Siparişiniz hazırlanıyor...\n");


                } else if (resultSet.getInt("order_status") == 2) {
                    System.out.print(resultSet.getInt("order_count") + " porsiyon ");
                    System.out.print(resultSet.getString("order_name"));
                    System.out.println(" - Sipariş tamamlandı.\n");

                }

            }

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getOrders() {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT order_name,order_roomnumber,order_status,order_id FROM hotelsdb.orders ");  // resultSeti nesneye aktarmak için kullanıyoruz
            int i = 0;
            while (resultSet.next()) {
                orders.add(new Order(resultSet.getString("order_name"),
                        resultSet.getInt("order_roomnumber"),
                        resultSet.getInt("order_status"),
                        resultSet.getInt("order_id")));


            }
        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateOrderStatus(int order_status, int order_id) {
        PreparedStatement statement = null;


        try {

            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE orders SET order_status=" + order_status + " WHERE order_id=" + order_id);// resultSeti nesneye aktarmak için kullanıyoruz
            statement.executeUpdate();
            System.out.println("Güncellendi.");

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateRoomStatus(int room_status, int room_number) {
        PreparedStatement statement = null;


        try {

            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE rooms SET room_status=" + room_status + " WHERE room_number=" + room_number);// resultSeti nesneye aktarmak için kullanıyoruz
            statement.executeUpdate();
            System.out.println("Güncellendi.");

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addProduct(String food_name, int food_calorie, int food_price, String food_category) {
        PreparedStatement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("insert into foods (food_name,food_calorie,food_price,food_category) values('" + food_name + "'," + food_calorie + "," + food_price + ",'" + food_category + "')");// resultSeti nesneye aktarmak için kullanıyoruz
            //resultSet = statement.executeQuery("INSERT INTO customers (customer_name,customer_surname,customer_age,customer_gender,customer_country,customer_roomnumber,customer_uniqueID) ('gokhan','akbas',19,'erkek','Turkiye',14,'45612asf')");  // resultSeti nesneye aktarmak için kullanıyoruz
            statement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Ürün Kaydedildi .");
    }

    public void getRooms() {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM hotelsdb.rooms ");  // resultSeti nesneye aktarmak için kullanıyoruz
            int i = 0;
            while (resultSet.next()) {
                rooms.add(new Room(resultSet.getString("room_option"),
                        resultSet.getInt("room_price"),
                        resultSet.getString("room_view"),
                        resultSet.getInt("room_number"),
                        resultSet.getInt("room_status")
                ));


            }
        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void setStuff(String stuff_name, String stuff_surname, int stuff_age, String stuff_gender, String stuff_username, String stuff_password, String stuff_department) {

        PreparedStatement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("insert into stuff (stuff_name,stuff_surname,stuff_age,stuff_gender,stuff_username,stuff_password,stuff_department) values('" + stuff_name + "','" + stuff_surname + "'," + stuff_age + ",'" + stuff_gender + "','" + stuff_username + "','" + stuff_password + "','" + stuff_department + "')");// resultSeti nesneye aktarmak için kullanıyoruz
            //resultSet = statement.executeQuery("INSERT INTO customers (customer_name,customer_surname,customer_age,customer_gender,customer_country,customer_roomnumber,customer_uniqueID) ('gokhan','akbas',19,'erkek','Turkiye',14,'45612asf')");  // resultSeti nesneye aktarmak için kullanıyoruz
            statement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Müşteri Kaydedildi .");
    }
    /*public void updateStuffEntryTime(String stuffUsername){
        PreparedStatement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE stuff SET stuff_entrytime='" + LocalDateTime.now().toString().substring(0,19) + "' WHERE stuff_username='" + stuffUsername+"'");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateStuffCheckOutTime(String stuffUsername){
        PreparedStatement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE stuff SET stuff_checkout='" + LocalDateTime.now().toString().substring(0,19) + "' WHERE stuff_username='" + stuffUsername+"'");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/



    public void stuffWorkHour(String stuffUsername){
        PreparedStatement statement = null;
        Statement statement1=null;
        int stuffWorkedHourData=0;
        String stuffEntryTime = null,stuffCheckOutTime=null;
        double stuffDailySalary=0;
        String[] timevalues1=new String[2];
        Integer[] timevalues2=new Integer[6];
        String[] timevalues3=new String[2];
        Integer[] timevalues4=new Integer[6];
        String[] timevalues5=new String[3];
        String[] timevalues6=new String[3];
        String[] timevalues7=new String[3];
        String[] timevalues8=new String[3];
        try {
            getStuff();
            /*connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement1 = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement1.executeQuery("SELECT * FROM stuff WHERE stuff_username='"+stuffUsername+"'");  // resultSeti nesneye aktarmak için kullanıyoruz
            while(resultSet.next()){
                stuffEntryTime=resultSet.getString("stuff_entrytime");
                stuffCheckOutTime=resultSet.getString("stuff_checkout");
                stuffWorkedHourData=resultSet.getInt("stuff_workedhour");
            }*/
            //'2022 - 12 - 17 T 00 : 10 : 44'
            for(int i=0;i< stuffs.size();i++){
                if(stuffs.get(i).getStuff_username().equalsIgnoreCase(stuffUsername)){
                    stuffEntryTime=stuffs.get(i).getStuff_entrytime();
                    stuffCheckOutTime=stuffs.get(i).getStuff_checkout();
                    stuffWorkedHourData=stuffs.get(i).getStuff_workedHourData();
                    stuffDailySalary=stuffs.get(i).getStuff_dailysalary();
                }
            }
            timevalues1=stuffEntryTime.split("T");

            timevalues5=timevalues1[0].split("-");
            timevalues6=timevalues1[1].split(":");

            timevalues2[0]=Integer.parseInt(timevalues5[0]);
            timevalues2[1]=Integer.parseInt(timevalues5[1]);
            timevalues2[2]=Integer.parseInt(timevalues5[2]);
            timevalues2[3]=Integer.parseInt(timevalues6[0]);
            timevalues2[4]=Integer.parseInt(timevalues6[1]);
            timevalues2[5]=Integer.parseInt(timevalues6[2]);

            timevalues3=stuffCheckOutTime.split("T");
            timevalues7=timevalues3[0].split("-");
            timevalues8=timevalues3[1].split(":");

            timevalues4[0]=Integer.parseInt(timevalues7[0]);
            timevalues4[1]=Integer.parseInt(timevalues7[1]);
            timevalues4[2]=Integer.parseInt(timevalues7[2]);
            timevalues4[3]=Integer.parseInt(timevalues8[0]);
            timevalues4[4]=Integer.parseInt(timevalues8[1]);
            timevalues4[5]=Integer.parseInt(timevalues8[2]);
            long timeHours=Duration.between(LocalDateTime.of(timevalues2[0],timevalues2[1],timevalues2[2],timevalues2[3],timevalues2[4],timevalues2[5]),LocalDateTime.of(timevalues4[0],timevalues4[1],timevalues4[2],timevalues4[3],timevalues4[4],timevalues4[5])).toHours();
            stuffWorkedHourData+=timeHours;
            double stuff_salary=stuffWorkedHourData*stuffDailySalary;
            connection=DbHelper.getConnection();
            statement = connection.prepareStatement("UPDATE stuff SET stuff_workedhour=" + stuffWorkedHourData + ",stuff_salary="+stuff_salary+" WHERE stuff_username='" + stuffUsername+"'");
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
