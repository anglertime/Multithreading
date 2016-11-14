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
			 *  Now I know IT!!!!!!!!!!!!! order ����һ�£���Ϊ����
			 *  Thread��ÿһ��for loop��Ĳ���������һ����������һ��lock��Ҳ����˵��
			 *  ����acquire the intrinsic lock of the specified Lock object,
			 *  Ȼ�����˳��һ�£���ôһ�������г�ͻ����Ϊat the same time, there is only
			 *  one Thread that can be using the first occured Lock object,
			 *  ����ֻҪ˳��һ�¾Ͳ��������⡣ 
			 *  
			 *  �����˳��һ�£��Ϳ���deadlock����Ϊ����Thread���Էֱ���Լ��ĵ�һ��Lock��Ȼ��
			 *  �����Ƿֱ�lock�������������lock�ڶ���Lock object��ʱ����Ϊ�ֱ𱻶Է�lock�ˣ�
			 *  �ͽ���deadlock��
			 *  
			 *  ��α��⣿ �ö��ַ�ʽ��1. �ɴ���һ��lock
			 *          	   2. ��֤ͬ��order
			 *          	   3. дException����
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
