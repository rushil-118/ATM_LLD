import java.util.Map;

public interface ICashDispenser {
    void dispense(int amount);
    Map<Integer, Integer> getAvailableNotes();
}
