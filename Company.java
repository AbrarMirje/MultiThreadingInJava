package MultiThreading;

public class Company {
    int item;
    boolean f = false;
//    f = false : Chance : Producer
//    f = true : Chance : Consumer
    synchronized public void produceItem(int item){
        if (f){
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        this.item = item;
        System.out.println("Item Produced: " + this.item);
        f = true;
        notify();
    }

    synchronized public int consumeItem(){
        if (!f){
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Consumed Item: " + this.item);
        f = false;
        notify();
        return this.item;
    }
}
