package work;


/*
编写一个list集合，存储通讯录，并输出通讯录
 */
import com.sun.prism.impl.Disposer;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class E337 {

    public static class Record implements Comparable<Record> {

        private  int id;
        private String name;
        private String phone;

        public Record() {
        }

        public Record(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String toString() {
            return  name + ":" + phone +" ";
        }

        public int compareTo(Record o) {
            return Collator.getInstance(Locale.CHINESEH).compare(this.name,o.getName());
        }

    }
    public static class  CommunicationRecord {
        private int size=0;
        private List<Record> list =new ArrayList<Record>();
        public CommunicationRecord() {

        }
        public int getSize() {
            return size;
        }
        public void add(Record r) {

            if(r!=null) {
                list.add(r);
                Collections.sort(list);
            }
        }

        public String  toString() {
            return list.toString();
        }

        public static void main(String[] args) {
            CommunicationRecord c=new CommunicationRecord();

            c.add(new Record("张三","111"));
            c.add(new Record("李四","222"));
            c.add(new Record("安安","444"));
            c.add(new Record("zz","6667"));
            c.add(new Record("abc","6667"));
            c.add(new Record("bbb","6667"));
            c.add(new Record("ccc","6667"));
            c.add(new Record("fff","6667"));
            c.add(new Record("gg","6667"));
            c.add(new Record("t","6667"));
            c.add(new Record("abc","6667"));
            c.add(new Record("王五","444"));
            c.add(new Record("赵六","222"));
            c.add(new Record("田七","444"));

            System.out.println(c);

        }
    }
}
