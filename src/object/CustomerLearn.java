package object;

public class CustomerLearn {
    private String firstName;
    private String lastName;
    private Account account;

    @Override
    public String toString() {
        return "CustomerLearn{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                '}';
    }

    public static void main(String[] args) {
        CustomerLearn customerLearn = new CustomerLearn("12","3");
        Account account = new Account(1000,2000,0.0123);
        customerLearn.setAccount(account);
        customerLearn.getAccount().deposit(100);
        customerLearn.getAccount().withdraw(100);

    }


    public CustomerLearn(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
