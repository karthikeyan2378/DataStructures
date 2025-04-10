package Concepts;

class MyThread implements Runnable {
    public void run() {  // Override run() method
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());

        t1.start(); // Starts the thread
        t2.start();
    }
}
