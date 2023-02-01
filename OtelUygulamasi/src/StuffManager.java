

public class StuffManager extends DbConnection {


    public void stuffRedirect(int index){
        getStuff();
        KitchenStuff kitchenStuff=new KitchenStuff();
        Waiters waiters=new Waiters();
        String department=stuffs.get(index).getStuff_department();
        if(department.equalsIgnoreCase("kitchen")){
            kitchenStuff.menu();
        }
        else if (department.equalsIgnoreCase("waiter")) {
            waiters.menu();
        }
//        }else if (department.equalsIgnoreCase("housekeeping")) {
//            // housekeeping menusune gidecek
//        }else if (department.equalsIgnoreCase("floorwalker")) {
//            // kat görevlisi menusune gidecek
//        }
    }



}
