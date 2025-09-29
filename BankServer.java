import java.util.HashMap;
import java.util.Map;

public class BankServer implements IBankServer {
    private Map<String, Account> accounts;
    
    public BankServer() {
        accounts = new HashMap<>();
    }
    
    @Override
    public Account getAccInfo(Card card) {
        if (card == null || card.getCardNumber() == null) {
            return null;
        }
        
        String cardNumber = card.getCardNumber();
        String accountNumber = "ACC" + cardNumber.substring(cardNumber.length() - 6);
        
        if (!accounts.containsKey(accountNumber)) {
            Account newAccount = new Account(
                accountNumber,
                card.getCardHolderName(),
                5000.00,
                "Checking"
            );
            accounts.put(accountNumber, newAccount);
        }
        
        return accounts.get(accountNumber);
    }
    
    @Override
    public boolean sendTransaction(ITransaction transaction) {
        try {
            boolean result = transaction.execute();
            System.out.println("Transaction sent to bank server: " + (result ? "Success" : "Failed"));
            return result;
        } catch (Exception e) {
            System.out.println("Failed to send transaction to bank server: " + e.getMessage());
            return false;
        }
    }
}
