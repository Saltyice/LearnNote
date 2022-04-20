package thread;

/**
 *  多线程练习
 *
 *  银行有一个账户。
 *  有两个存户分别向一个账户存3000元，每次存1000，存三次。
 *  每次存在打印账户余额
 *
 *
 *
 */
public class DepositThread {
    public static void main(String[] args) {
        CIF cif = new CIF();
        CIF cif1 =new CIF();
        Thread thread = new Thread(cif);
        Thread thread1 = new Thread(cif1);
        thread.setName("NO1");
        thread1.setName("NO2");
        thread.start();
        thread1.start();
    }
}
class BankAccount {
      int balance;

}

class CIF implements Runnable{
    static BankAccount account=new BankAccount();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (account){
                account.balance+=1000;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+account.balance);
            }
        }
    }
}