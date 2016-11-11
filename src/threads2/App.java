package threads2;
// two kinds of problems when you have model 1 thread showing the same data 1. data being cached 2. has to do with threads into leaving?
// look at basic threads sync

import java.util.Scanner;

//class Processor extends Thread {
//	@Override
//	public void run() {
//		while(true) {
//			System.out.println("Hello");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}
public class App {
	public static void main(String args[]) {
		Processor proc1 = new Processor();
		proc1.start();
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
		
	}
	
	private static class Processor extends Thread {
		/* 
		 * I never set it to true. Running never changes in this thread. 
		 * I am gonna optimize. I am not gonna bother checking the value of running every
		 * time I go run the while loop. I will assume the running would be always true.
		 * And I keep going forever.  
		 * so, to prevent that happening, you use volatile keyword. It is used to prevent
		 * threads caching variables that do not change from within that thread. If you want
		 * to change the variable from another thread, you have to either use volatile 
		 * keyword or use some thread synchronization.
		 * 
		 * Specifically, when you read a volatile variable from one thread,
		 *  all writes up to and including the write to that volatile variable 
		 *  from other threads are now visible to that one thread. And, yes, you can use static 
		 *  with volatile. They do different things
		 *  
		 * When a field is declared volatile, the compiler and runtime are put on notice that this 
		 * variable is shared and that operations on it should not be reordered with other memory 
		 * operations. Volatile variables are not cached in registers or in caches where they are 
		 * hidden from other processors, so a read of a volatile variable always returns the most 
		 * recent write by any thread.
		 */
		private volatile boolean running = true;
		@Override
		public void run() {
			while(running) {
				System.out.println("Hello");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void shutdown() {
			running = false;
		}
	}
}
