package work;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*

 */
public class E338 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(4);
        list1.add(4);
        list1.add(5);
        list1.add(1);
        list1.add(7);
        list1.add(9);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(8);
        list2.add(5);
        list2.add(11);
        list2.add(17);
        list2.add(9);
        list2.add(2);
        list2.add(3);
        list2.add(19);

        TreeSet<Integer> set = new TreeSet<Integer>(list1);
        set.addAll(list2);
        List<Integer> ss = new ArrayList<Integer>(set);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ss.size(); i = i + 2) {

            list.add(ss.get(i));

        }
        for (int i = (ss.size()) / 2 * 2 - 1; i > 0; i = i - 2) {
            list.add(ss.get(i));
        }
        System.out.println(list);
    }

}
