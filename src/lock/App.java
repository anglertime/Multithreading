package lock;

public class App {
	/*
	 * We look at how you use lock of objects explicitly and to make more efficient 
	 * code in some circumstances where by using multiple locks. It is not always
	 * ideal to just use the one intrinsic lock that you have with your object. This
	 * is because you often want to use multiple locks to protect multiple different
	 * things.
	 */

	public static void main(String[] args) {
		new Worker().main();
	}

}
