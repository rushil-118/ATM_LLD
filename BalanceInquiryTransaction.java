public class BalanceInquiryTransaction implements ITransaction {
    private ATM atm;
    
    public BalanceInquiryTransaction(ATM atm) {
        this.atm = atm;
    }
    
    @Override
    public boolean execute() {
        try {
            Account account = atm.getCard().getBankServer().getAccInfo(atm.getCard());
            
            if (account == null) {
                System.out.println("Unable to retrieve account information");
                return false;
            }
            
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Current Balance: " + account.getBalance());
            System.out.println("Account Type: " + account.getAccountType());
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
            return false;
        }
    }
}
