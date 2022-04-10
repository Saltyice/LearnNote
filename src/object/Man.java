package object;

public class Man {
    String name;
    int age;
    int id=99;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Man() {

    }

    public void eat(){
        System.out.println("eat");

    }

    public void walk(int distance){
        System.out.println("walk"+distance);
    }

     Object info(){
        return null;
    }

     double info1(){
        return 2d;
    }
}
