package interactiveBroker;

import java.util.HashMap;
import java.util.Map;

class FindValue {

    public static void main(String[] args) {

    	Map<Integer, String> hashMap = new HashMap<Integer, String>(5);
        hashMap.put(1, "apple");
        hashMap.put(2, null);
        hashMap.put(new Integer(3), "peach");
        hashMap.put(3, "orange");
        hashMap.put(4, "peach");

        for (String v : hashMap.values()) {

            if ("orange".equals(v)) {
                hashMap.put(5, "banana");
            }    
        }
        System.out.println(hashMap.get(5));


    }

}
