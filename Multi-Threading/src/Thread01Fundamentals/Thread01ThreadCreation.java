package Thread01Fundamentals;

public class Thread01ThreadCreation {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in Thread: " + Thread.currentThread().getName());
                System.out.println("Current Thread Priority is: " + Thread.currentThread().getPriority());

                throw new RuntimeException("Intentional Exception");
            }
        });

        thread.setName("New Worker Thread");

        thread.setPriority(Thread.MAX_PRIORITY);

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread: " + t.getName() + "\nThe error is: " + e.getMessage());
            }
        });

        System.out.println("We are in Thread: " + Thread.currentThread().getName() + " before starting new thread");
        thread.start();
        System.out.println("We are in Thread: " + Thread.currentThread().getName() + " after starting new thread");
    }
}
