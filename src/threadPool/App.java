package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	/*
	 * Thread pool is a way of managing lots of threads at the same time. 
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for (int i = 0 ; i < 5 ; i ++) {
			executor.submit(new Processor(i));
		}
		
		// this will shut down immediately. It will wait till all threads terminate.
		executor.shutdown();
		
		System.out.println("All tasks submitted");
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");
	}
	
	private static class Processor implements Runnable {
		private int id;
		
		public Processor(int id) {
			this.id = id;
		}
		
		@Override
		public void run() {
			System.out.println("Starting: " + id);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Completed " + id);
		}
	}
}
