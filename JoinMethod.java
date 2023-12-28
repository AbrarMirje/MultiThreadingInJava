package MultiThreading;

/*
    join() method is used to keep thread in temporary waiting state, If we want to execute particular
    thread completely among the threads.
    Join method will throw the checked exception i.e. InterruptedException.
    Other threads can change their execution sequence, but thread which calls join() method will complete
    their execution, and then it will give the chance to the other threads.
    It depends upon where you called the join() method, if you call it before any other threads, means
    at the beginning then it will execute at first, if you called it last then it will execute last.
    In join(), sequence matters.
 */
class Join extends Thread {
    @Override
    public void run() {

        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
public class JoinMethod {
    public static void main(String[] args) {
        Join join1 = new Join();
        Join join2 = new Join();
        Join join3 = new Join();

//        Setting the name
        join1.setName("Thread 1");
        join2.setName("Thread 2");
        join3.setName("Thread 3");

//        Start the Thread
        join2.start();
        try {
            join2.join();   // Main Thread will Halt here... and join2 thread will start the execution
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        join1.start();
        join3.start();
    }
}
