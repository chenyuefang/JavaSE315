package work;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
创建和迭代一个Map
 */
public class E325 {
    public static void main(String[] args) {
        Map<String,Integer > map=new HashMap<String ,Integer>();
        map.put("zhangsan",89);
        map.put("Lisi",98);
        map.put("Wangwu",56);

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for (Map.Entry<String,Integer> entry : entrySet){
            System.out.println(entry.getKey() + ":" +entry.getValue());
        }
    }
}
