import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class MeetingRoom implements Runnable {

    ArrayList<Consumer> consumers = new ArrayList<>();
    Datum datum;
    Lock roomLock = new ReentrantLock();

    public MeetingRoom(int numOfConsumers) {

        for (int i = 1; i <= numOfConsumers; i++) {
            consumers.add(new Consumer(i));
        }

        for (Consumer consumer : consumers) {
            subscribe(consumer);
        }

    }

    public void subscribe(Consumer consumer) {

        System.out.println("Consumer #" + consumer.getID() + " has subscribed to the meeting room!");
        consumer.setSubscribed(true);

        /*

        MeetingRoom will have a subscribe method that all Consumers will call once, preferably shortly after they're
        created.  It is up to you to design this method.  Will it take an integer argument representing the unique ID
        of the consumer who's subscribing?  Will it take a Consumer argument, and the Consumer calling it will pass
        itself as the argument?  Something else? This is up to you.

        How can an instance variable call the class's method?
        What is the purpose of the method?


    // Each Consumer will call the MeetingRoom's subscribe method to indicate that they would like to receive data intended for them.

        */

    }

    @Override
    public void run() {

        while (true) {
            roomLock.lock();
            try {
                if (datum != null) {
                    consumers.get(datum.getID() - 1).receive(datum.getData());
                    datum = null;
                    roomLock.unlock();

                }
                else {
                    System.out.println("There is no data to be received :(");
                    roomLock.unlock();
                }

                Thread.sleep((int) (100 * Math.random()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
