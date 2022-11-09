public class Consumer {

    private int data;
    private int ID;
    private boolean subscribed = false;

    public int getID() {
        return ID;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public boolean isSubscribed() {return this.subscribed;};

    public Consumer(int ID) {
        this.ID = ID;
    }

    public void receive(int data) {
        System.out.println("---> Consumer #" + ID + " received " + data);
    }


}
