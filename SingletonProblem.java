// Problem: Each time a user can create mulitple Logger objects 
// In this case user has create 2 objects
public class SingletonProblem {
    public class Logger {
        private static int instanceCount = 0;

        public Logger() {
            // Constructor
            instanceCount++;
            System.out.println("No of instances: " + instanceCount);
        }

        public void log(String message) {
            System.out.println("[LOG] " + message);
        }

    }

    public class Client {
        public static void main(String[] args) {
            // Creating multiple instances of Logger
            Logger logger1 = new Logger();
            logger1.log("Message 1 logged");
            Logger logger2 = new Logger();
            logger2.log("Message 2 logged");
        }
    }
}
