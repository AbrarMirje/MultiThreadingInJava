package MultiThreading;

public class Produce extends Thread {
    Company c;
    public Produce(Company c){
        this.c = c;
    }
    public void run(){
        int i = 1;
        while (true){
            this.c.produceItem(i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            i++;
        }
    }
}
