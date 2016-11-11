package demo2;


public class App {
	public static void main(String[] args) {
		// second way to start a Thread (run codes simutaniously)
		// by implementing Runnable
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		
		t1.start();
		t2.start();
	}
	private static class Runner implements Runnable {
		@Override
		public void run() {
			for (int i = 0 ; i < 5 ; i ++) {
				System.out.println("Hello " + i);
				
				// static method of the Thread class
				// sleep for x million seconds
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}