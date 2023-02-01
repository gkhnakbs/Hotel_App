public class Order {
    private int order_roomnumber,order_status,order_id;
    private String order_name;

    public Order(String order_name,int order_roomnumber, int order_status, int order_id ) {
        this.order_roomnumber = order_roomnumber;
        this.order_status = order_status;
        this.order_id = order_id;
        this.order_name = order_name;
    }

    public int getOrder_roomnumber() {
        return order_roomnumber;
    }

    public void setOrder_roomnumber(int order_roomnumber) {
        this.order_roomnumber = order_roomnumber;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }
}
