package Primenumber;

public class LongCounter {
    private Long counter;

    public LongCounter(){
        counter = 0l;
    }
//    To måder at synkronisere tråde og de objekter de arbejder med
//    Skrive synchronized i metode statementet
    public synchronized void increment(){
        counter++;
    }
//    Skrive synchronized rundt omkring metodens indhold
    public void decrement(){
        synchronized (this) {
            counter--;
        }
    }

    public long get(){
        return counter;
    }

}
