package day02;

public class finalTest {
    public static void main(String[] args) {

    }
}


/**
 * final: class field method
 */

class finalClass{
    private final int anInt;


    public finalClass() {
        anInt = 1;
    }

    public finalClass(int anInt) {
        this.anInt = anInt;
    }

    public final void method() {
//        this.anInt = 1;
    }
}

class SubTest extends finalClass{
//    public void method() {
//
//    }
}