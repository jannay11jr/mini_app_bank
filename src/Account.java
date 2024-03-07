public class Account {
    private int balance;

    public Account () {
        balance = 0;
    }

    public void setBalance(int balance) {
        this.balance = this.balance + balance;
    }

    public int getBalance() {
        return balance;
    }
}
