public class Consumer {

    private int data;
    private int ID;

    public Consumer(int ID) {
        this.ID = ID;
    }

    // will be called by MeetingRoom when the room has data intended for this Consumer
    public void receive(int data) {
        System.out.println("---> Consumer #" + ID + " has recieved " + data + "!");
    }

}
