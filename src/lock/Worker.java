package lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	private Random random = new Random();
	
	/*
	 *  lock1 and lock2 are two different objects and they both
	 *  have their own intrinsic lock. Therefore, we could use 
	 *  them to declare separate synchronized blocks.
	 */
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	public void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list1.add(random.nextInt(100));
		}
	}
	
	public synchronized void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list2.add(random.nextInt(100));
		}
	}
	
	public void process() {
		for (int i = 0 ; i < 1000 ; i ++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main() {
		System.out.println("Hello world! Now Let's start...");
		
		long start = System.currentTimeMillis();
		
//		process();
		
//		Thread t1 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				process();
//			}
//		});
//		
//		t1.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// we need to make the two stages synchronized
		/*
		 *  if we do nothing more, the synchronized method will use the
		 *  only intrinsic lock. Therefore, we need multiple locks. This
		 *  is because there is ONLY ONE thread could use the intrinsic
		 *  lock AT A TIME!!!
		 */
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken: " + (end - start));
		System.out.println("List1: " + list1.size() + " " + "List2: " + list2.size());
	}

}
