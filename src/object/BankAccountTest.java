package object;

public class BankAccountTest {
}

class BankAccount {
    private int bankId;
    private String passWord;
    private double balance;
    private static double rate;
    private static int totalId=1001;
    private final static  double minBalance=0;

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankId=" + bankId +
                ", passWord='" + passWord + '\'' +
                ", balance=" + balance +
                '}';
    }

    public BankAccount(String passWord, double balance) {
        this.passWord = passWord;
        this.balance = balance;
    }

    public BankAccount(){
      bankId =  totalId++;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        BankAccount.rate = rate;
    }
}