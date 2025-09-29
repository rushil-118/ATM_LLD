public class TransactionState implements IATMState {
    private ITransaction transaction;
    
    public TransactionState(ITransaction transaction) {
        this.transaction = transaction;
    }
    
    @Override
    public void displayState(ATM atm) {
        System.out.println("Processing transaction...");
        
        if (transaction.execute()) {
            System.out.println("Transaction completed successfully!");
        } else {
            System.out.println("Transaction failed. Please try again.");
        }
        
        System.out.println("Would you like to perform another transaction? (y/n)");
        String response = atm.getInputMethod().readInput();
        
        if ("y".equalsIgnoreCase(response) || "yes".equalsIgnoreCase(response)) {
            atm.setState(new AuthenticatedState());
        } else {
            System.out.println("Thank you for using our ATM. Please take your card.");
            atm.setState(new InitState());
            atm.setCard(null);
        }
    }
}
