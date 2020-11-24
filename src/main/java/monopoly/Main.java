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
    }

    private static List<Player> getPlayers() {
        List<PropertyCard> propertyCards = PropertyCard.getPropertyCards();
        List<ChanceCard>  chanceCards = ChanceCard.getChanceCards();
        Player firstPlayer = new Player("Nazar", propertyCards.get(1), chanceCards.get(1));
        Player secondPlayer = new Player("Oleh", propertyCards.get(2), chanceCards.get(2));
        Player thirdPlayer = new Player("Dmytro", propertyCards.get(3), chanceCards.get(3));
        return List.of(firstPlayer, secondPlayer, thirdPlayer);
    }
}
