public class DepositTransaction implements ITransaction {
    private ATM atm;
    private double amount;
    
    public DepositTransaction(ATM atm, double amount) {
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
            
            if (amount <= 0) {
                System.out.println("Invalid deposit amount");
                return false;
            }
            
            account.deposit(amount);
            System.out.println("Deposit successful: $" + amount);
            System.out.println("New balance: $" + account.getBalance());
            return true;
            
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
            return false;
        }
    }
}
