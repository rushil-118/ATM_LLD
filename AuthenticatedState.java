public class AuthenticatedState implements IATMState {
    
    @Override
    public void displayState(ATM atm) {
        System.out.println("Authentication successful!");
        System.out.println("Please select a transaction:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance Inquiry");
        System.out.println("4. Exit");
        
        int choice = atm.getInputMethod().readIntInput();
        
        TransactionFactory factory = new TransactionFactory();
        ITransaction transaction = factory.createTransaction(atm, choice);
        
        if (transaction != null) {
            atm.setState(new TransactionState(transaction));
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }
}
