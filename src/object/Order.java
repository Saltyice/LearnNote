package object;

public class Order {
    //私有权限的只有在 类内部才能使用
    private int orderPrivate;
    int orderDefault;
    public int orderPublic;

    private void methodPrivate(){
        orderPrivate=1;
        orderDefault=2;
        orderPublic=3;
    }

    void methodDefault(){
        orderPrivate=1;
        orderDefault=2;
        orderPublic=3;

    }
    public void methodPublic(){
        orderPrivate=1;
        orderDefault=2;
        orderPublic=3;
    }


}
