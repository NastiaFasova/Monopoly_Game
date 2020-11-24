package monopoly;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private PropertyCard propertyCard;
    private ChanceCard chanceCard;

    public Player(String name) {
        this.name = name;
    }

    public PropertyCard getProperty() {
        List<PropertyCard> propertyCards = PropertyCard.getPropertyCards();
        PropertyCard card = propertyCards.get((int) (Math.random() * (propertyCards.size()) - 1) + 1);
        setPropertyCard(card);
        return card;
    }

    private PropertyCard generateProperty() {
        List<PropertyCard> propertyCards = PropertyCard.getPropertyCards();
        return propertyCards.get((int) (Math.random() * (propertyCards.size()) - 1) + 1);
    }

    public List<Card> getInfoAboutPlayer() {
        List<Card> cards = new ArrayList<>();
        cards.add(getPropertyCard());
        cards.add(getChanceCard());
        System.out.println("Name: " + getName());
        System.out.println("PropertyCard: " + getPropertyCard().getDescription());
        System.out.println("ChanceCard: " + getChanceCard().getDescription());
        return cards;
    }
}
