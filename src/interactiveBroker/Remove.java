package interactiveBroker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Remove {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

//if (list != null) {
//    for (String s : list)
//        if ("bad".equals(s)) list.iterator().current().remove();
//}


if (list != null) {
    for (Iterator itr = list.iterator(); itr.hasNext(); ) {
        if ("bad".equals(itr.next())) itr.remove();
    }
}


		// TODO Auto-generated method stub

	}

}
