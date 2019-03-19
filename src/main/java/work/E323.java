package work;

import java.util.ArrayList;
import java.util.List;


/*
创建和迭代一个List
 */
public class E323 {
    public static void main(String[] args) {
        List<String> names=new ArrayList<String>();
        names.add("Tom");
        names.add("Jerry");
        names.add("Black");
        names.add("Andy");
        names.add("Lee");
        for (int i = 0; i < names.size(); i++) {
            String str=names.get(1);
            System.out.println(str);
        }
    }

}
