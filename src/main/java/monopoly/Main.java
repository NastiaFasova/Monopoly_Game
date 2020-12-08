package monopoly;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Look at this color: " + Color.BLUE);
        Monopoly game = new Monopoly();
        game.setPlayers(getPlayers());
        System.out.println("Lets start with all available Chances:");
        game.getAvailableChances();
        System.out.println("Lets walk through all available Properties:");
        System.out.println(Arrays.toString(game.getAvailableProperties()));
        System.out.println("Overall Info about game: ");
        game.getInfoAboutGame();
        System.out.println("Lets get one random Chance Card:");
        game.generateRandomChance();
        System.out.println("Now well see one random Property:");
        game.generateRandomProperty();
        System.out.println("What about banknotes in the Bank?");
        game.getBank().showBank();

        //Use of split()
        System.out.println(Arrays.toString(game.generateRandomChance()));
        System.out.println(Arrays.toString(game.generateRandomProperty()));

        //Use of concatenation of different types
        System.out.println(game.getPropertiesByIndex(1));

        System.out.println("The average price of propertyCards: "
                + game.getTheAveragePriceOfPropertyCards());
        System.out.println("The overall price of all properties: "
                + game.getPriceOfAllProperties());
        System.out.println("The cheapest propertyCard: "
                + game.getTheCheapestPropertyCard());
        System.out.println("The most expensive propertyCard: "
                + game.getTheMostExpensivePropertyCard());
        System.out.println("The most famous gain of property Card:  "
                + game.getTheMostRapidPropertyCardAmongPlayers());
        game.getAppropriateCards(50, 150);
    }

    private static List<Player> getPlayers() {
        List<PropertyCard> propertyCards = PropertyCard.getPropertyCards();
        List<ChanceCard>  chanceCards = ChanceCard.getChanceCards();
        Player firstPlayer = new Player("Nazar", List.of(propertyCards.get(1)), List.of(chanceCards.get(1)));
        Player secondPlayer = new Player("Oleh", List.of(propertyCards.get(2)), List.of(chanceCards.get(2)));
        Player thirdPlayer = new Player("Dmytro", List.of(propertyCards.get(3)), List.of(chanceCards.get(3)));
        return List.of(firstPlayer, secondPlayer, thirdPlayer);
    }
}
