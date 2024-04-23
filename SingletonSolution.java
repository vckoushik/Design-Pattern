//Solution: Make constructor private and use getLogger method to get object
public class SingletonSolution {
    public class Logger {
        //Make private so no one uses it directly
        private static Logger logger = null;
        private static int instanceCount = 0;

        private Logger() {
            // Constructor
            instanceCount++;
            System.out.println("No of instances: " + instanceCount);
        }

        // Make sure 2 threads are not creating 2 loggers initially - synchronized
        public static synchronized Logger getLogger() {
            if (logger == null) {
                logger = new Logger();
            }
            return logger;
        }

        public void log(String message) {
            System.out.println("[LOG] " + message);
        }

    }

    public class Client {
        public static void main(String[] args) {
            // Only one Logger object is used by 2 users
            Logger logger1 = Logger.getLogger();
            logger1.log("Message 1 logged");
            Logger logger2 = Logger.getLogger();
            logger2.log("Message 2 logged");
        }
    }
}
