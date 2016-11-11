package demo3;

public class App {
	public static void main(String[] args) {
		// a handy way to start a thread (because Runnable is an interface)
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0 ; i < 3 ; i ++) {
					System.out.println("Hello " + i);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t1. start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0 ; i < 3 ; i ++) {
					System.out.println("Hello " + i);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t2. start();
	}
}
