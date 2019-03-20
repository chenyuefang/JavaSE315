package day04;

public class PESC <N extends Number> { // N的类型只能是Number

    private void print(N n1, N n2) {
        System.out.println(n1);
        System.out.println(n2);
    }

    public static void main(String[] args) {
        PESC<Integer> p1 = new PESC<>();
        p1.print(1, 2);

        PESC<Double> p2 = new PESC<>();
        p2.print(1.1, 2.2);

//        PECS<String> p3 = new PECS<>();
    }
}
