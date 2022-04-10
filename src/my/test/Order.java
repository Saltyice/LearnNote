package my.test;

public class Order {

    private int orderPrivate;
    int orderDefault;
    protected int orderProtected;
    public int orderPublic;

    private void methodPrivate(){
        orderPrivate =1;
        orderDefault =1;
        orderProtected =1;
        orderPublic =1;
    }

    void methodDefault(){
        orderPrivate =1;
        orderDefault =1;
        orderProtected =1;
        orderPublic =1;
    }

    protected  void methodProtected(){
        orderPrivate =1;
        orderDefault =1;
        orderProtected =1;
        orderPublic =1;
    }

    public void methodPublic()  {
        orderPrivate =1;
        orderDefault =1;
        orderProtected =1;
        orderPublic =1;
    }
}
