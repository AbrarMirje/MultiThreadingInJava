package MultiThreading;

/*
    Daemon Thread is used for provide support or services to the another Thread. The life span of
    Daemon thread is till the life of running thread. When running thread will terminate then along
    with that Daemon thread also will get terminate.
    We can declare a thread as Daemon by just calling a boolean method setDaemon(true); This method will
    set current thread as a Daemon Thread.
    To check the current thread is Daemon or not we can use isDaemon() method which is public boolean
    method which returns true if thread is Daemon thread or false if it will not.
    The best example of Daemon thread is Garbage Collector. When program will terminate, then the
    Garbage Collector will collect all the objects and references from the memory and clean it for next
    processing.
 */
class MyDaemonRunnable implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Daemon thread is running");
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class DaemonThreadExample {

    public static void main(String[] args) {
        // Create a new thread and set it as a daemon thread
//        MyDaemonRunnable myDaemonRunnable = new MyDaemonRunnable();

//        We can directly call MyDaemonRunnable Constructor
        Thread daemonThread = new Thread(new MyDaemonRunnable());
        daemonThread.setDaemon(true);

        // Start the daemon thread
        daemonThread.start();

        // Main thread continues its execution
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Main thread completes, and the JVM exits because the daemon thread does not prevent it
    }
}

