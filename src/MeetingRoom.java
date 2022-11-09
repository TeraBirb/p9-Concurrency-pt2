import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.*;

public class MeetingRoom implements Runnable {

    ArrayList<Consumer> consumers = new ArrayList<>();
    ArrayList<Datum> data = new ArrayList<>();
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
    }

    @Override
    public void run() {

        while (true) {

            roomLock.lock();

            try {
                if (!data.isEmpty()) {

                    Iterator<Datum> iterator = data.iterator();

                    while (iterator.hasNext()) {
                        Datum currentDatum = iterator.next();
                        Consumer currentConsumer = consumers.get(currentDatum.getID() - 1); // ID starts at 1

                        if (currentConsumer.isSubscribed()) {
                            currentConsumer.receive(currentDatum.getData());
                            currentConsumer.setData(currentDatum.getData());
                        }
                        else {
                            System.out.println("There is data intended for consumer #" + currentConsumer.getID() +
                                    " but it is not subscribed! :(");
                        }

                        iterator.remove();

                    }

                    roomLock.unlock();

                }
                else {
                    System.out.println("There is no data to be received :(");
                    roomLock.unlock();
                }

                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
