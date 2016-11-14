package interactiveBroker;

import java.util.ArrayList;
import java.util.List;

class MyBook {
	protected String name;
	private int price;
	protected int pages;
	public MyBook() {
		name = "";
	}
	public MyBook(String newName, int newPrice, int newPages) {
		name = newName;
		price = newPrice;
		pages = newPages;
	}
}

public class Book {
	public static void main(String args[]) {
		List<Beauty> list = new ArrayList<>();
		list.add(new Beauty());
		List<? extends MyBook> books = list;
		
		MyEnum[] allVal = MyEnum.values();
		MyEnum first = MyEnum.values()[0];
		
		MyEnum second = MyEnum.TUESDAY;
		MyEnum third = MyEnum.valueOf("THURSDAY");
		
		for (MyEnum day : MyEnum.values()) {
			System.out.println(day);
		}
		
		for (MyXN slaves : MyXN.values()) {
			System.out.println(slaves.name);
		}
	}
	
	private static class Beauty extends MyBook {
		String name;
		int age;
		public Beauty() {
			name = a.name;
		}
		MyBook a = new MyBook("Fuck Sun Xinyue", 1, 100);
		
	}
	
	public enum MyXN {
		SXY("Sun Xinyue", 26),
		ZQ("Zeng Qin", 26),
		LSY("Liao Shiyu", 30),
		GX("Guan Xi", 30);
		
		private String name;
		private int age;
		
		private MyXN(String newName, int newAge) {
			name = newName;
			age = newAge;
		}
		
		public String getValue() {
			return name;
		}
	}
	
	public enum MyEnum {
		MONDAY(0),
		TUESDAY(1),
		WEDNESDAY(2),
		THURSDAY(3);
		
		private int val;
		private MyEnum(int newVal) {
			val = newVal;
		}
		public int getValue() {
			return val;
		}
	}
}