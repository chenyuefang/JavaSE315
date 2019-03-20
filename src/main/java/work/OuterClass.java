package work;

/*
内部类的实现方式
（以成员内部类为例说明内部类的实现方式）
 */
public class OuterClass {

   private class InterClass {
        public InterClass () {
            System.out.println("InterClass Create");
        }

   }
    public OuterClass () {
        InterClass ic=new InterClass();
        System.out.println("OuterClass Create");
    }

    public static void main(String[] args) {
        OuterClass oc=new OuterClass();
    }
}


