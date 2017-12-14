//Two threads are in deadlock status

public class Deadlock {
    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] args) {
        Thread a = new Thread(new Thread1());
        Thread b = new Thread(new Thread2());
        a.start();
        b.start();
    }

}

class Thread1 implements Runnable {
    public void run() {
        synchronized (Deadlock.obj1) {
            try {
                System.out.println(Thread.currentThread().getName() + " getting obj1");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " after sleep 500ms");
            } catch(Exception e) {
                e.printStackTrace();
            }
            synchronized (Deadlock.obj2) {
                System.out.println(Thread.currentThread().getName() + " getting obj2");
            }
        }
    }
}

class Thread2 implements Runnable {
    public void run() {
        synchronized (Deadlock.obj2) {
            try {
                System.out.println(Thread.currentThread().getName() + " getting obj2");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " after sleep 500ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (Deadlock.obj1) {
                System.out.println(Thread.currentThread().getName() + " getting obj1");
            }
        }
    }
}