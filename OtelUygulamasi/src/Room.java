public class Room {
    private String room_option,room_view;
    private int room_number,room_status,room_price;

    public Room(String room_option, int room_price, String room_view, int room_number, int room_status) {
        this.room_option = room_option;
        this.room_price = room_price;
        this.room_view = room_view;
        this.room_number = room_number;
        this.room_status = room_status;
    }

    public String getRoom_option() {
        return room_option;
    }

    public void setRoom_option(String room_option) {
        this.room_option = room_option;
    }

    public int getRoom_price() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price = room_price;
    }

    public String getRoom_view() {
        return room_view;
    }

    public void setRoom_view(String room_view) {
        this.room_view = room_view;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public int getRoom_status() {
        return room_status;
    }

    public void setRoom_status(int room_status) {
        this.room_status = room_status;
    }
}
