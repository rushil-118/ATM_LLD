public class InitState implements IATMState {
    
    @Override
    public void displayState(ATM atm) {
        System.out.println("ATM is in Initial State");
        System.out.println("Please insert your card...");
        System.out.println("Card inserted!");
        atm.setState(new CardInserted());
    }
}
