package interactiveBroker;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

 

public class Test{

    public static void main(String[] args) {
    	String str = new String("23");
    	if (str.matches("^([0-9]+)$")) {
    		System.out.println("true");
    	}
        final List<Integer> list = new ArrayList<Integer>();

        Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);

        final Integer pos = Integer.valueOf(3);

        list.remove(pos);

        System.out.println(list);

    }

}
