package work;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/*
* 创建和迭代一个Set
*
* */
public class E324 {

    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");

        Iterator<String> ite=set.iterator();
        while (ite.hasNext()) {
            String egg =ite.next();
            System.out.println(egg);
        }

    }
}
