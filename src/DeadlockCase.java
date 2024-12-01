
public class DeadlockCase {
	 public static void main(String[] args) {
	        // Shared resources
	        final Object resource1 = new Object();
	        final Object resource2 = new Object();

	        // Creating the first thread
	        Thread thread1 = new Thread(() -> {
	            synchronized (resource1) {
	                System.out.println("Thread 1: Locked Resource 1");
	                try {
	                    // Simulate some work with Resource 1
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }

	                System.out.println("Thread 1: Waiting to lock Resource 2");
	                synchronized (resource2) {
	                    System.out.println("Thread 1: Locked Resource 2");
	                }
	            }
	        });

	        // Creating the second thread
	        Thread thread2 = new Thread(() -> {
	            synchronized (resource2) {
	                System.out.println("Thread 2: Locked Resource 2");
	                try {
	                    // Simulate some work with Resource 2
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }

	                System.out.println("Thread 2: Waiting to lock Resource 1");
	                synchronized (resource1) {
	                    System.out.println("Thread 2: Locked Resource 1");
	                }
	            }
	        });

	        // Start both threads
	        thread1.start();
	        thread2.start();
	        

	    }
}
