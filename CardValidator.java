public class CardValidator implements ICardValidator {
    
    @Override
    public boolean isCardValid(Card card) {
        if (card == null) {
            return false;
        }
        
        String cardNumber = card.getCardNumber();
        if (cardNumber == null || cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            return false;
        }
        
        if (card.getCardHolderName() == null || card.getCardHolderName().trim().isEmpty()) {
            return false;
        }
        
        String expirationDate = card.getExpirationDate();
        if (expirationDate == null || !expirationDate.matches("\\d{2}/\\d{2}")) {
            return false;
        }
        
        return true;
    }
}
