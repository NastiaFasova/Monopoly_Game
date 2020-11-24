package monopoly;

import java.util.HashMap;
import java.util.Map;

public class NotRealBank {
    private Map<Nominal, Integer> banknotes;

    public NotRealBank(){
        banknotes = new HashMap<Nominal, Integer>();
    }

    public NotRealBank(Map<Nominal, Integer> banknotes) {
        this.banknotes = banknotes;
    }

    public Map<Nominal, Integer> addBanknotes(Nominal n, int quantity){
        banknotes.put(n, quantity);
        return banknotes;
    }

    public Integer getQuantity(Nominal n){
        return banknotes.getOrDefault(n, 0);
    }

    public void showBank(){
        for(Map.Entry<Nominal, Integer> entry : banknotes.entrySet()){
            System.out.println("Nominal: " + entry.getKey().val + "\nBanknotes in this bank: " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "NotRealBank{" +
                "banknotes=" + banknotes +
                '}';
    }
}
