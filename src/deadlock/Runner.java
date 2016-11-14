package deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private Account acc1 = new Account();
	private Account acc2 = new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	public void firstThread() throws InterruptedException {
		Random random = new Random();
		System.out.println("first  ");
		for (int i = 0 ; i < 100 ; i ++) {
			/*
			 *  Now I know IT!!!!!!!!!!!!! order 必须一致，因为两个
			 *  Thread的每一次for loop里的操作，都是一上来先做第一个lock，也就是说先
			 *  尝试acquire the intrinsic lock of the specified Lock object,
			 *  然后如果顺序一致，那么一定不会有冲突，因为at the same time, there is only
			 *  one Thread that can be using the first occured Lock object,
			 *  所以只要顺序一致就不会有问题。 
			 *  
			 *  而如果顺序不一致，就可能deadlock，因为两个Thread可以分别读自己的第一个Lock，然后
			 *  把它们分别lock，这样再想继续lock第二个Lock object的时候，因为分别被对方lock了，
			 *  就进入deadlock了
			 *  
			 *  如何避免？ 好多种方式：1. 干脆用一个lock
			 *          	   2. 保证同样order
			 *          	   3. 写Exception处理
			 */
			lock1.lock();
			lock2.lock();
			System.out.println("first " + i);
			Account.transfer(acc1, acc2, random.nextInt(100));
			
			lock1.unlock();
			lock2.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException {
		Random random = new Random();
		System.out.println("second");
		for (int i = 0 ; i < 100 ; i ++) {
			lock2.lock();
			lock1.lock();
			System.out.println("seco  " + i);
			Account.transfer(acc2, acc1, random.nextInt(100));
			
			lock1.unlock();
			lock2.unlock();
		}
	}
	
	public void finished() {
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
	}
}
