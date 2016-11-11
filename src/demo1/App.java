package demo1;

public class App {

	public static void main(String[] args) {
		// first basic way to start a thread(separate operating system process which can run concurrently with other threads)
		// the first basic way is to extend the Thread class
		Runner runner1 = new Runner();
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.start();
	}
	
	private static class Runner extends Thread {
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

//class Runner extends Thread {
//	@Override
//	public void run() {
//		for (int i = 0 ; i < 5 ; i ++) {
//			System.out.println("Hello " + i);
//			
//			// static method of the Thread class
//			// sleep for x million seconds
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}
