package ar.com.ada.threading;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        simpleRun();

        //deadLockRun();
    }
    public static void simpleRun() {
        new MyThread("One");

        new MyThread("Two");

        new MyThread("Three");

        try {

            Thread.sleep(10000);

        } catch (InterruptedException e) {

            System.out.println("Main thread Interrupted");

        }

        System.out.println("Main thread exiting.");

    }

    public static void deadLockRun() {

        final String resource1 = "this is the resource #1";
        final String resource2 = "this is the resource #2";
        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: locked resource 1");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }

}
