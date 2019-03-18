package day02;

public class Person {
    private String name;
    private char gender;
    private int age;

    public Person() {
    }

    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void information(){
        System.out.println(" name "+" "+ name  +" gender" + " "+ gender + "age" +" "+age );
    }

}
