class Bank {

    private long[] bal;

    public Bank(long[] balance) {
        this.bal = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (!valid(account1) || !valid(account2)) return false;
        if (bal[account1 - 1] < money) return false;

        bal[account1 - 1] -= money;
        bal[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (!valid(account)) return false;
        bal[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!valid(account)) return false;
        if (money > bal[account - 1]) return false;
        bal[account - 1] -= money;
        return true;
    }

    private boolean valid(int acc){
        return acc >= 1 && acc <= bal.length;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */