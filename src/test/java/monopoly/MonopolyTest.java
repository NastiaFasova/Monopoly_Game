package monopoly;

import monopoly.exception.LowPriceOfPropertyCardException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MonopolyTest {
    private static final double DELTA = 1e-15;

    Monopoly monopoly = new Monopoly();

    @Test
    public void GetAvailableProperties_getCards_Ok() throws LowPriceOfPropertyCardException {
        List<PropertyCard> properties = monopoly.getProperties();
        properties.clear();
        PropertyCard card1 = new PropertyCard("pA",
                "A street.", "somebody walks", 200, 3);
        PropertyCard card2 = new PropertyCard("pB",
                "A house.", "somebody stays", 500, 50);
        properties.add(card1);
        properties.add(card2);
        String[] expected = {"pA",  "pB"};
        String[] actual = monopoly.getAvailableProperties();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void GetProperties_GetCardByIndex_Ok() throws LowPriceOfPropertyCardException {
        List<PropertyCard> properties = monopoly.getProperties();
        PropertyCard card = new PropertyCard("pA",
                "A street.", "somebody walks", 200, 3);
        properties.add(0, card);
        String expected = "A street.3200";
        String actual = monopoly.getPropertiesByIndex(0);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = LowPriceOfPropertyCardException.class)
    public void GetProperties_GetCardByIndex_ThrowsException()
            throws LowPriceOfPropertyCardException {
        new PropertyCard("pA",
                "A street.", "somebody walks", 90, 3);
    }

    @Test
    public void GetPriceOfAllProperties_ReturnsNumber_Ok() {
        Assert.assertEquals(4000D, monopoly.getPriceOfAllProperties(), DELTA);
    }

    @Test
    public void GetTheMostExpensivePropertyCard_ReturnsPropertyCard_Ok() {
        PropertyCard expected =
                new PropertyCard("pE", "A hotel.", "somebody sleeps", 2000, 250);
        Assert.assertEquals(expected, monopoly.getTheMostExpensivePropertyCard());
    }

    @Test
    public void GetTheCheapestPropertyCard_ReturnsPropertyCard_Ok() {
        PropertyCard expected
                = new PropertyCard("pA", "A street.", "somebody walks", 200, 3);
        Assert.assertEquals(expected, monopoly.getTheCheapestPropertyCard());
    }

    @Test
    public void GetTheAveragePriceOfPropertyCards_ReturnsNumber_Ok() {
        Assert.assertEquals(800D, monopoly.getTheAveragePriceOfPropertyCards(), DELTA);
    }

    @Test
    public void getAppropriateCards_ReturnsMap_Ok() {
        Map<String, List<PropertyCard>> map = new HashMap<>();
        PropertyCard propertyCard1
                = new PropertyCard("pC", "A library.", "somebody reads", 300, 10);
        PropertyCard propertyCard2
                = new PropertyCard("pD", "A shop.", "somebody buys", 1000, 100);
        monopoly.setProperties(List.of(propertyCard1, propertyCard2));
        map.put("Fits", List.of(propertyCard2));
        map.put("Don't fit", List.of(propertyCard1));
        Assert.assertEquals(map, monopoly.getAppropriateCards(50, 100));
    }

    @Test
    public void GetTheMostRapidPropertyCardAmongPlayers_ReturnsNumberOfPrice_Ok() {
        PropertyCard propertyCard1
                = new PropertyCard("pC", "A library.", "somebody reads", 300, 10);
        PropertyCard propertyCard2
                = new PropertyCard("pD", "A shop.", "somebody buys", 1000, 100);
        Player firstPlayer = new Player("Nazar", List.of(propertyCard1));
        Player secondPlayer = new Player("Oleh", List.of(propertyCard1));
        Player thirdPlayer = new Player("Dmytro", List.of(propertyCard2));
        monopoly.setPlayers(List.of(firstPlayer, secondPlayer, thirdPlayer));
        Assert.assertEquals(Integer.valueOf(10), monopoly.getTheMostRapidPropertyCardAmongPlayers());
    }

}