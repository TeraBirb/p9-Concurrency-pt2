public class Consumer {

    private int data;
    private int ID;
    private boolean subscribed = false;

    public int getID() {
        return ID;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public Consumer(int ID) {
        this.ID = ID;
    }

    // will be called by MeetingRoom when the room has data intended for this Consumer
    public void receive(int data) {
        System.out.println("---> Consumer #" + ID + " has recieved " + data + "!");
    }


}
