public class Supplier implements Runnable {

    private Datum datum;
    private int ID;

    public Supplier(int data, int ID) {
        this.datum = new Datum(data, ID);
        this.ID = ID;
    }

    @Override
    public void run() {

    }

}
