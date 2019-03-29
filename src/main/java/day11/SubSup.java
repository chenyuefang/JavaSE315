

package day11;

public class SubSup {

    public static void main(String[] args) {
        Sub sub = new Sub(1);
        sub.m();
    }
}


class Sup {
    private int i;

    public Sup() {
        System.out.println("Sup constructor...");
    }

    public Sup(int i) {
        this.i = i;
    }

    protected void m() {
        //...
        System.out.println("Sup method...");
    }
}

class Sub extends Sup {
    public Sub(int i) {
        super();
//        super(i);
        String s = "hello";
    }

    @Override
    public void m() {
        super.m();
        System.out.println("Sub method...");
    }

    //    public Sub() {
//        super();
//        System.out.println("Sub constructor...");
//    }
}

