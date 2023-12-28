package MultiThreading;
class UserDefinedThread extends Thread {
    @Override
    public void run() {
        System.out.println("This is user defined thread");
    }
}
public class ThreadOperations {
    public static void main(String[] args) {
        System.out.println("Program started");
        int x = 10 + 20;
        System.out.println("sum is: " + x);
//        Printing Thread name
        Thread thread = Thread.currentThread();
        System.out.println("Current Running Thread Is: " + thread.getName());

//      To set Thread name
        thread.setName("JavaProgramming");
        System.out.println("Renamed thread is: " + thread.getName());
        System.out.println("Current Running Thread Is: " + thread.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
//        To get id of Thread
        System.out.println(thread.threadId());
//        Going to start user defined thread
        UserDefinedThread userDefinedThread = new UserDefinedThread();
        userDefinedThread.start();
        System.out.println("Program Terminated");
    }
}
