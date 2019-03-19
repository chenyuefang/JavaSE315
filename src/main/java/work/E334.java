package work;

/*
通过一次循环，清除掉一个ArrayList中的每一个元素
 */

import sun.text.resources.en.FormatData_en_IE;

import java.util.ArrayList;

public class E334 {
    public static void main(String[] args) {
        ArrayList<String> list =new ArrayList<String>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("c");
        list.add("b");
        list.add("b");
        list.add("a");

        for (int i = list.size()-1; i >=0 ; i--) {
            list.remove(i);

        }
        System.out.println(list);
    }

}
