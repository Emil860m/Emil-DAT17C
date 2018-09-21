package Primenumber;
public class Prime {
    public static void main(String [] args) {
        long max = 10_000_000L;
        LongCounter counter = new LongCounter();
        int noOfThreads = 4;
        Thread[] threadArray = new Thread[noOfThreads];

        long start = System.currentTimeMillis();
        for (int i = 1; i <= noOfThreads ; i++) {
            int finalI = i;
            Thread t = new Thread(()->{
                for(int j = (int)max/(noOfThreads)-1; j <=max/noOfThreads* finalI; j++){
                    if (isPrime(j)) {
                        counter.increment();
                    }
                }
            });
            threadArray[i-1] = t;

        }

        for (int i = 0; i < threadArray.length ; i++) {
            threadArray[i].start();
            try {
                threadArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*Thread t1 = new Thread(()->{
        for(int i = 1; i <=(max/noOfThreads);i++){
                if (isPrime(i)) {
                    counter.increment();
                }
            }
        });
        Thread t2 = new Thread(()->{
            for(int i = (int)max/2 + 1; i <=max;i++){
                if (isPrime(i)) {
                    counter.increment();
                }
            }
        });*/






        System.out.println(counter.get() + " primes");
        long stop = System.currentTimeMillis();
        System.out.println(stop-start);
    }


    public static boolean isPrime(long number){
        if(number == 2){
            return true;
        }
        if(number%2==0){
            return false;
        }
        for (int i = 3; i <= Math.sqrt(number); i+=2) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
