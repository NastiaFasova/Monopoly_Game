package monopoly;

import monopoly.exception.LowPriceOfPropertyCardException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MonopolyTest {

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
}