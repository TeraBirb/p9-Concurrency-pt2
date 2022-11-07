public class Supplier implements Runnable {

    private Datum datum;
    private int ID;
    private MeetingRoom meetingRoom;

    public Supplier(int data, int ID, MeetingRoom meetingRoom) {
        this.datum = new Datum(data, ID);
        this.ID = ID;
        this.meetingRoom = meetingRoom;
    }

    @Override
    public void run() {

    }

}
