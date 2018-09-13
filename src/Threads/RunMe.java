package Threads;

public class RunMe {
    public static void main(String [] args){
        LongCounter c = new LongCounter();
//        Disse gør det samme, som er at oprette og definere en thread
//        Første gør brug af en Lambda expression for at gøre det mere overskueligt, samt mindre skrivearbejde
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                c.increment();
            }

        });
//        Klassisk måde at skrive det, uden en lambda expression
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    c.decrement();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter is " + c.get());
    }
}
