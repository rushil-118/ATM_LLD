import java.util.Scanner;

public class ConsoleInput implements IInput {
    private Scanner scanner;
    
    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }
    
    @Override
    public String readInput() {
        return scanner.nextLine();
    }
    
    @Override
    public int readIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return readIntInput(); 
        }
    }
}
