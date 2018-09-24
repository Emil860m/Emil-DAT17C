package Primenumber;
public class Prime {
    public static void main(String [] args) throws InterruptedException {
        long max = 10_000_000L;
        LongCounter counter = new LongCounter();
        int noOfThreads = 1000;
        Thread[] threadArray = new Thread[noOfThreads];

        double start = System.currentTimeMillis();
        for (int i = 1; i <= noOfThreads ; i++) {

            int finalI = i;
            Thread t = new Thread(()->{
                for(int j = (int) (1+((max/(noOfThreads)*finalI)-(max/noOfThreads))); j <=(max/noOfThreads)* finalI; j++){
                    if (isPrime(j)) {
                        counter.increment();
                    }
                }
            });
            threadArray[i-1] = t;

        }
        for (Thread t: threadArray) {
            t.start();
            }
        for (Thread t: threadArray) {
            t.join();
        }

//        threadArray[0].start();
//        threadArray[1].start();
//        threadArray[2].start();
//        threadArray[3].start();
//        threadArray[4].start();
//        threadArray[0].join();
//        threadArray[1].join();
//        threadArray[2].join();
//        threadArray[3].join();
//        threadArray[4].join();

//        for (int i = 0; i < threadArray.length ; i++) {
//            threadArray[i].start();
//            try {
//                threadArray[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

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
        double stop = System.currentTimeMillis();
        System.out.println((stop-start)/1000 + " seconds");
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
