public class ATM {
    private IATMState state;
    private Card card;
    private ICashDispenser cashDispenser;
    private IInput inputMethod;
    
    public ATM(ICashDispenser cashDispenser, IInput inputMethod) {
        this.cashDispenser = cashDispenser;
        this.inputMethod = inputMethod;
        this.state = new InitState();
    }
    
    public void setState(IATMState state) {
        this.state = state;
    }
    
    public void callState() {
        state.displayState(this);
    }
    
    public Card getCard() {
        return card;
    }
    
    public void setCard(Card card) {
        this.card = card;
    }
    
    public ICashDispenser getCashDispenser() {
        return cashDispenser;
    }
    
    public IInput getInputMethod() {
        return inputMethod;
    }
    
    public IATMState getState() {
        return state;
    }
}
