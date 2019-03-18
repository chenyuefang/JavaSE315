package day02;

public class Cube {
    public static void main(String[] args) {
        Cube1 cube1 = new Cube1(1, 2, 3);
        System.out.println(cube1.getVolume());
    }
}

class Cube1 {

    private double length;
    private double width;
    private double height;

    public Cube1(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }
}
