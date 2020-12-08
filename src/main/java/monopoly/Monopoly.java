package monopoly;

import lombok.Data;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

@Data
public class Monopoly {
    private NotRealBank bank;
    private Random rnd;
    private List<ChanceCard> chances;
    private List<PropertyCard> properties;
    private List<Player> players;

    public static class Cube {
        private int num;

        public int generateRandomNum() {
            return (int) ((Math.random() * 5) + 1);
        }
    }

    public NotRealBank bankToDefault(){
        bank = new NotRealBank();
        bank.addBanknotes(Nominal.ONE, 100);
        bank.addBanknotes(Nominal.TEN, 100);
        bank.addBanknotes(Nominal.TWENTY, 100);
        bank.addBanknotes(Nominal.FIFTY, 50);
        bank.addBanknotes(Nominal.HUNDREED, 50);
        bank.addBanknotes(Nominal.FIVEHUNDREED, 20);
        this.setBank(bank);
        return bank;
    }

    Monopoly(){
        bankToDefault();
        rnd = new Random();
        properties = PropertyCard.getPropertyCards();
        chances = ChanceCard.getChanceCards();
    }

    //Use of split()
    public String[] generateRandomChance(){
        int ind = rnd.nextInt(chances.size());
        String result = chances.get(ind).printInfo() + chances.get(ind).action();
        return result.split("\\n");
    }

    //Use of split()
    public String[] generateRandomProperty(){
        int ind = rnd.nextInt(properties.size());
        String result = properties.get(ind).printInfo() + properties.get(ind).action();
        return result.split("\\n");
    }

    public void getAvailableChances(){
        Iterator<ChanceCard> iter = chances.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().getTitle());
        }
    }

    //Use of split()
    public String[] getAvailableProperties(){
        Iterator<PropertyCard> iter = properties.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Titles of properties: ");
        while(iter.hasNext()){
            stringBuilder.append(iter.next().getTitle()).append(" ");
        }
        return stringBuilder.toString().split(" ");
    }

    //Use of concatenation of different types
    public String getPropertiesByIndex(int index) {
        PropertyCard card = properties.get(index);
        return card.getDescription() + card.getGain() + card.getPrice();
    }

    public List<Player> getInfoAboutGame() {
        for (Player player : players) {
            System.out.println("Name: " + player.getName());
            System.out.println("PropertyCard: " + player.getPropertyCards());
            System.out.println("ChanceCard: " + player.getChanceCards());
        }
        return players;
    }

    public double getPriceOfAllProperties() {
        return getProperties()
                .stream()
                .map(PropertyCard::getPrice)
                .reduce(0,Integer::sum);
    }

    public PropertyCard getTheMostExpensivePropertyCard() {
        return getProperties()
                .stream()
                .max(Comparator.comparing(PropertyCard::getPrice))
                .orElseThrow(RuntimeException::new);
    }

    public PropertyCard getTheCheapestPropertyCard() {
        return getProperties()
                .stream()
                .min(Comparator.comparing(PropertyCard::getPrice))
                .orElseThrow(RuntimeException::new);
    }

    public Double getTheAveragePriceOfPropertyCards() {
        return getProperties()
                .stream()
                .mapToDouble(PropertyCard::getPrice)
                .average()
                .orElseThrow(RuntimeException::new);
    }

    public Map<String, List<PropertyCard>> getAppropriateCards(int lowBound, int upperBound) {
        Map<String, List<PropertyCard>> map = new HashMap<>();
        List<PropertyCard> cards = getProperties()
                .stream()
                .filter(e -> e.getGain() >= lowBound)
                .filter(e -> e.getGain() <= upperBound)
                .collect(Collectors.toList());
        map.put("Fits", cards);
        List<PropertyCard> restOfCards = getProperties()
                .stream()
                .filter(e -> !cards.contains(e))
                .collect(Collectors.toList());
        map.put("Don't fit", restOfCards);
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        return map;
    }

    public Integer getTheMostRapidPropertyCardAmongPlayers() {
        List<Integer> mostRapidGainOfPropertyCard = players
                .stream()
                .flatMap(b -> b.getPropertyCards().stream())
                .map(PropertyCard::getGain)
                .collect(Collectors.toList());

        return mostRapidGainOfPropertyCard.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(o
                        -> Collections.frequency(mostRapidGainOfPropertyCard, o)))).orElse(null);
    }
}
