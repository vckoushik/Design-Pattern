
//Behavioural Pattern
//Publish Subscriber
import java.util.*;

public class ObserverSolution {

    public interface ISubscriber {
        public void notify(String message);
    }

    public static class User implements ISubscriber {
        private int userId;

        public User(int userId) {
            this.userId = userId;
        }

        public void notify(String message) {
            System.out.println("UserId: " + userId + " receieved message " + message);
        }
    }

    // GROUP is the Publisher
    public static class Group {
        private ArrayList<ISubscriber> subscribers;

        public Group() {
            subscribers = new ArrayList<>();
        }

        public void subscribe(ISubscriber subscriber) {
            subscribers.add(subscriber);
        }

        public void unsubscribe(ISubscriber subscriber) {
            subscribers.remove(subscriber);
        }

        public void notify(String message) {
            for (ISubscriber subscriber : subscribers) {
                subscriber.notify(message);
            }
        }
    }

    public static void main(String[] args) {
        Group group = new Group();

        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);

        group.subscribe(user1);
        group.subscribe(user2);
        group.subscribe(user3);

        group.notify("New Notification");

    }
}
