package Thread01Fundamentals;

import java.math.BigInteger;

public class Thread03ThreadInterruption {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new BlockingTask());
//        thread.start();

//        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000000000"), new BigInteger("30000000")));
//        thread.start();
//        Thread.sleep(100);
//        thread.interrupt();

        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000000000"), new BigInteger("30000000")));
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }

    private static class BlockingTask implements  Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5000000);
            } catch (InterruptedException e) {
                System.out.println("Existing Blocking Thread");
            }
        }
    }

    private static class LongComputationTask implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }


        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i=i.add(BigInteger.ONE)) {
//                if(Thread.currentThread().isInterrupted()) {
//                    System.out.println("Prematurely interrupted computation");
//                    return BigInteger.ZERO;
//                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}


