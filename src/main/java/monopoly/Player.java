package monopoly;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private String name;
    private List<PropertyCard> propertyCards;
    private List<ChanceCard> chanceCards;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, List<PropertyCard> propertyCards) {
        this.name = name;
        this.propertyCards = propertyCards;
    }

    public PropertyCard getProperty() {
        List<PropertyCard> propertyCards = PropertyCard.getPropertyCards();
        PropertyCard card = propertyCards.get((int) (Math.random() * (propertyCards.size()) - 1) + 1);
        propertyCards.add(card);
        return card;
    }

    private PropertyCard generateProperty() {
        List<PropertyCard> propertyCards = PropertyCard.getPropertyCards();
        return propertyCards.get((int) (Math.random() * (propertyCards.size()) - 1) + 1);
    }

    public List<Card> getInfoAboutPlayer() {
        List<Card> cards = new ArrayList<>(getPropertyCards());
        cards.addAll(chanceCards);
        System.out.println("Name: " + getName());
        propertyCards.forEach(System.out::println);
        chanceCards.forEach(System.out::println);
        return cards;
    }

    public List<PropertyCard> getPropertiesOfPlayer() {
        return propertyCards;
    }
}
