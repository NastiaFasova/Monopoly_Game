package monopoly;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChanceCard extends Card {

    public ChanceCard() {
    }

    ChanceCard(String title, String description, String effect) {
        super(title, description, effect);
    }

    @Override
    public String getTitle() {
        return "\"" + title + "\"";
    }

    public String printInfo(){
        return "Your chance is here!\n" + getTitle() + "\n" + getDescription() + "\n";
    }

    public String action(){
        return "Well, now you have to " + getEffect();
    }

    public static List<ChanceCard> getChanceCards() {
        List<ChanceCard> chanceCards = new ArrayList<ChanceCard>();
        chanceCards.add(new ChanceCard("A", "Taxes!", "pay 150."));
        chanceCards.add(new ChanceCard("B", "Rent!", "pay 200."));
        chanceCards.add(new ChanceCard("C", "Competition!", "gain 10."));
        chanceCards.add(new ChanceCard("D", "Fine!", "pay 20."));
        chanceCards.add(new ChanceCard("E", "Salary!", "gain 500."));
        return chanceCards;
    }

    @Override
    public String toString() {
        return "ChanceCard{" +
                "title='" + title + '\'' +
                "} " + super.toString();
    }
}
