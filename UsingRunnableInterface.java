package MultiThreading;

public class UsingRunnableInterface implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread 1: " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
//        Creating object of Runnable Interface
        UsingRunnableInterface usingRunnableInterface = new UsingRunnableInterface();
//        Assigning created thread reference variable to the Thread class
        Thread thread = new Thread(usingRunnableInterface);


//        Creating Object of Thread Class
        ByExtendingThreadClass byExtendingThreadClass = new ByExtendingThreadClass();
        thread.start();
        byExtendingThreadClass.start();
    }
}
