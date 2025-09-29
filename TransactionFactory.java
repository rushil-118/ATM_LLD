public class TransactionFactory {
    
    public ITransaction createTransaction(ATM atm, int transactionType) {
        switch (transactionType) {
            case 1:
                System.out.println("Enter amount to withdraw:");
                double withdrawAmount = atm.getInputMethod().readIntInput();
                return new WithdrawTransaction(atm, withdrawAmount);
                
            case 2:
                System.out.println("Enter amount to deposit:");
                double depositAmount = atm.getInputMethod().readIntInput();
                return new DepositTransaction(atm, depositAmount);
                
            case 3:
                return new BalanceInquiryTransaction(atm);
                
            case 4:
                System.out.println("Thank you for using our ATM. Please take your card.");
                atm.setState(new InitState());
                atm.setCard(null);
                return null;
                
            default:
                return null;
        }
    }
}
