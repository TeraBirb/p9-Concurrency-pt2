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

        while (true) {
            meetingRoom.roomLock.lock();
            try {
                if (meetingRoom.datum == null) {

                    System.out.println("----> Supplier #" + ID + " has dropped off " + datum.getData());
                    meetingRoom.datum = datum;
                    meetingRoom.roomLock.unlock();

                } else {
                    System.out.println("Supplier #" + ID + ": meeting room is full :(");
                    meetingRoom.roomLock.unlock();
                }


                Thread.sleep((int) (1000 * Math.random()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
