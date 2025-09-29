public class Main {
    public static void main(String[] args) {
        ICashDispenser cashDispenser = new CashDispenser();
        IInput inputMethod = new ConsoleInput();
        ATM atm = new ATM(cashDispenser, inputMethod);
        IBankServer bankServer = new BankServer();
        Card card = new Card("1234567890123456", "rushil", "12/25", bankServer);
        
        System.out.println("Welcome to the ATM System!");
        System.out.println("=========================");
        atm.setCard(card);
        boolean running = true;
        while (running) {
            try {
                atm.callState();
                
                if (atm.getState() instanceof InitState && atm.getCard() == null) {
                    running = false;
                }
                
                Thread.sleep(1000);
                
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                atm.setState(new InitState());
            }
        }
        
        System.out.println("ATM session ended. Goodbye!");
    }
}
