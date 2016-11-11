package countdownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	/*
	 * We saw early on we can get a lot of terrible problems with threads
	 * synchronization if you try to access even the simplest integer from
	 * multiple threads at the same time.
	 * 
	 * Luckily/Fortunately, there are a bunch of classes in Java that
	 * are thread safe. You can really safely access from multiple threads
	 * without worrying about the thread synchronization. And countdownlatch
	 * is one of them.
	 */
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i = 0 ; i < 3 ; i ++) {
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed.");
	}
	
	private static class Processor implements Runnable {
		private CountDownLatch latch;
		public Processor(CountDownLatch latch) {
			this.latch = latch;
		}
		@Override
		public void run() {
			System.out.println("Started.");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
		}
	}
}
