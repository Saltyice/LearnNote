package object;

public class Account  {
    private int id;
    private double balance;
    private double rate;

    public Account(int id, double balance, double rate) {
        this.id = id;
        this.balance = balance;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void withdraw(double amount) {




        if (balance<amount){
            System.out.println();
            return;
        }
        balance -=amount;
    }

    public void deposit(double amount){
        if (amount>0){
            balance += amount;
        }
    }
}
