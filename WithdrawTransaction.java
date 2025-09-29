public class WithdrawTransaction implements ITransaction {
    private ATM atm;
    private double amount;
    
    public WithdrawTransaction(ATM atm, double amount) {
        this.atm = atm;
        this.amount = amount;
    }
    
    @Override
    public boolean execute() {
        try {
            Account account = atm.getCard().getBankServer().getAccInfo(atm.getCard());
            
            if (account == null) {
                System.out.println("Unable to retrieve account information");
                return false;
            }
            
            if (account.getBalance() < amount) {
                System.out.println("Insufficient funds");
                return false;
            }
            
            if (account.withdraw(amount)) {
                atm.getCashDispenser().dispense((int)amount);
                System.out.println("Please take your cash: $" + amount);
                System.out.println("Remaining balance: $" + account.getBalance());
                return true;
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
            return false;
        }
    }
}
