public class Card {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private IBankServer bankServer;
    
    public Card(String cardNumber, String cardHolderName, String expirationDate, IBankServer bankServer) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.bankServer = bankServer;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public String getCardHolderName() {
        return cardHolderName;
    }
    
    public String getExpirationDate() {
        return expirationDate;
    }
    
    public IBankServer getBankServer() {
        return bankServer;
    }
    
    public static Card readCard(String cardNumber, String cardHolderName, String expirationDate, IBankServer bankServer) {
        return new Card(cardNumber, cardHolderName, expirationDate, bankServer);
    }
}
