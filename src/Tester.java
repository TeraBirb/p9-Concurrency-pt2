public class Tester {

    public static final int NUM_OF_SUPPLIERS = 10;
    public static final int NUM_OF_CONSUMERS = 10;

    public static void main(String[] args) {

        var meetingRoom = new MeetingRoom(NUM_OF_CONSUMERS);
        new Thread(meetingRoom).start();

        for (int i = 1; i <= NUM_OF_SUPPLIERS; i++) {
            new Thread(new Supplier((int)(1000 * Math.random()), i, meetingRoom)).start();
        }

    }

}
