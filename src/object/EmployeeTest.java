package object;

/**
 *
 * 抽象类练习
 *
 *
 */
public class EmployeeTest {

    public static void main(String[] args) {
        //多态 +抽象 父类的引用指向了子类的对象
        MyEmployee manager = new Manager("",1,1,1);
        //多态+抽象
        manager.work();

    }
}


abstract class MyEmployee{
    private String name;
    private int id;
    private double salary;

    public MyEmployee( ) {
    }

    public MyEmployee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

}

class  Manager extends MyEmployee{
    private double bonus;

    public Manager() {

    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("");
    }
}

class CommonEmployee extends MyEmployee{


    @Override
    public void work() {
        System.out.println("");
    }
}