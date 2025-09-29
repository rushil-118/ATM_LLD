public class CardInserted implements IATMState {
    
    @Override
    public void displayState(ATM atm) {
        System.out.println("Card has been inserted");
        System.out.println("Please enter your PIN:");
        
        String pin = atm.getInputMethod().readInput();
        
        ICardValidator validator = new CardValidator();
        if (validator.isCardValid(atm.getCard()) && isValidPin(pin)) {
            System.out.println("Authentication successful!");
            atm.setState(new AuthenticatedState());
        } else {
            System.out.println("Invalid PIN or card. Please try again.");
            atm.setState(new InitState());
        }
    }
    
    private boolean isValidPin(String pin) {
        return pin != null && pin.length() == 4 && pin.matches("\\d+");
    }
}
