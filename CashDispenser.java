import java.util.HashMap;
import java.util.Map;

public class CashDispenser implements ICashDispenser {
    private Map<Integer, Integer> availableNotes;
    
    public CashDispenser() {
        availableNotes = new HashMap<>();
        availableNotes.put(100, 50);
        availableNotes.put(50, 100);
        availableNotes.put(20, 200);
        availableNotes.put(10, 300);
    }
    
    @Override
    public void dispense(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        
        Map<Integer, Integer> notesToDispense = calculateNotesToDispense(amount);
        
        if (notesToDispense.isEmpty()) {
            System.out.println("Unable to dispense the requested amount");
            return;
        }
        
        for (Map.Entry<Integer, Integer> entry : notesToDispense.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            availableNotes.put(denomination, availableNotes.get(denomination) - count);
        }
        
        System.out.println("Dispensing cash:");
        for (Map.Entry<Integer, Integer> entry : notesToDispense.entrySet()) {
            System.out.println("$" + entry.getKey() + " x " + entry.getValue());
        }
    }
    
    @Override
    public Map<Integer, Integer> getAvailableNotes() {
        return new HashMap<>(availableNotes);
    }
    
    private Map<Integer, Integer> calculateNotesToDispense(int amount) {
        Map<Integer, Integer> result = new HashMap<>();
        int remainingAmount = amount;
        
        for (int denomination : new int[]{100, 50, 20, 10}) {
            if (availableNotes.containsKey(denomination) && availableNotes.get(denomination) > 0) {
                int maxNotes = Math.min(remainingAmount / denomination, availableNotes.get(denomination));
                if (maxNotes > 0) {
                    result.put(denomination, maxNotes);
                    remainingAmount -= maxNotes * denomination;
                }
            }
        }
        
        if (remainingAmount > 0) {
            return new HashMap<>();
        }
        
        return result;
    }
}
