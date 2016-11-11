package threadSync;

public class App {
	// volatile does not work here because the problem is not because of caching.
	// private volatile int count = 0;
	private int count = 0;
	/* what synchronized really does is every object in Java has a what we called
	* an intrinsic lock or a monitor lock. If you called a synchronized method of an object,
	* in this case, we called the increment() method of app. You have to acquire the 
	* intrinsic lock before you can call it. The thing is only one thread can acquire the
	* intrinsic lock at a time. If one thread acquires the intrinsic lock and runs this
	* method, and if another thread at the same time tries to call this method, then the 
	* second thread has to wait until the first thread releases the intrinsic lock by 
	* the method finishing executing. 
	* 
	* You need to be aware of this whenever you got multiple threads accessing sharing data.
	* If you declare/run some synchronized block. 
	*
	*/
	private synchronized void increment() {
		count ++;
	}
	public static void main(String[] args) {
		App app = new App();
		app.doWork();
	}
	private void doWork() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				int a = 100;
				int b = 1000;
				int c = 10000;
				int d = 5000;
				for (int i = 0 ; i < c ; i ++) {
					count = count + 1;
					
//					System.out.println("a" + count);
//					System.out.println("b" + count + 1);
//					System.out.println("c");
					
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
//					increment();
//					count ++;
				}
			}
		});
		t1. start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				int a = 100;
				int b = 1000;
				int c = 10000;
				int d = 5000;
				for (int i = 0 ; i < c ; i ++) {
					count = count + 1;
					
//					System.out.println("AAAA" + count);
//					System.out.println("BBBB" + count + 1);
//					System.out.println("CCCC");
					
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
//					increment();
//					count ++;
				}
			}
		});
		t2. start();
		
		// let t1 and t2 finish
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count);
	}
}
