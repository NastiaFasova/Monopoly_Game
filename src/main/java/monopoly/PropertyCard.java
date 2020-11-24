package monopoly;

import lombok.Data;
import monopoly.exception.LowPriceOfPropertyCardException;

import java.util.ArrayList;
import java.util.List;

@Data
public class PropertyCard extends Card {
    private static final int MIN_PRICE = 100;
    private Integer price;
    private Integer gain;

    public PropertyCard() {
    }

    public PropertyCard(String t, String d, String e) {
        super(t, d, e);
    }

    PropertyCard(String title, String description, String effect,
                 Integer price, Integer gain) throws LowPriceOfPropertyCardException {
        super(title, description, effect);
        if (price < MIN_PRICE) {
            throw new LowPriceOfPropertyCardException("Price of Property Card should be more than 200");
        }
        this.price = price;
        this.gain = gain;
    }

    public String printInfo(){
        return "This is the property:\n" + getTitle() + "\n" + getDescription() + "\n ";
    }

    public String action(){
        return "You can buy " + getTitle() + " for a fair price of " + price
                + ", gain here equals " + gain + " when " + getEffect() + "; ";
    }

    public static List<PropertyCard> getPropertyCards() {
        List<PropertyCard> properties = new ArrayList<PropertyCard>();
        try {
            properties.add(new PropertyCard("pA", "A street.", "somebody walks", 200, 3));
            properties.add(new PropertyCard("pB", "A house.", "somebody stays", 500, 50));
            properties.add(new PropertyCard("pC", "A library.", "somebody reads", 300, 10));
            properties.add(new PropertyCard("pD", "A shop.", "somebody buys", 1000, 100));
            properties.add(new PropertyCard("pE", "A hotel.", "somebody sleeps", 2000, 250));
        } catch (LowPriceOfPropertyCardException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Override
    public String toString() {
        return "PropertyCard{" +
                "price=" + price +
                ", gain=" + gain +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
