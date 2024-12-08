class MyThread extends Thread {
@SuppressWarnings("deprecation")
public void run() {
try {
System.out.println("Thread state during sleep: " + Thread.currentThread().getState());
Thread.sleep(2000); // Timed Waiting
synchronized (this)
{
System.out.println("Thread state while waiting for lock: " + Thread.currentThread().getState());
wait(); // Waiting
System.out.println("Thread state after wait: " + Thread.currentThread().getState());
}
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Thread state at the end of run(): " + Thread.currentThread().getState());
}
}

public class ThreadStateExample{
public static void main(String[] args) throws InterruptedException
{
MyThread myThread = new MyThread();
System.out.println("Initial thread state: " + myThread.getState()); // New
myThread.start(); // Runnable
Thread.sleep(100);
System.out.println("Thread state after start() but before sleep(): " + myThread.getState());
Thread.sleep(2500);
System.out.println("Thread state after completion of run(): " + myThread.getState()); //Terminated
}
}