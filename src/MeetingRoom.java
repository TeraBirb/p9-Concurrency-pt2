import java.util.ArrayList;

public class MeetingRoom implements Runnable {

    ArrayList<Consumer> consumers = new ArrayList<>();

    public MeetingRoom(int numOfConsumers) {

        for (int i = 1; i <= numOfConsumers; i++) {
            consumers.add(new Consumer(i));
        }

    }

    @Override
    public void run() {
        // if there is data for a specific consumer, call consumer.receive()
    }

}
