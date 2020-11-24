package monopoly.equals_hashcode;

import monopoly.Nominal;
import monopoly.NotRealBank;
import monopoly.PropertyCard;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EqualsExamplesTest {

    private EqualsExamples examples = new EqualsExamples();

    @Test
    public void OverriddenEquals_EqualCards_True() {
        PropertyCard firstCard
                = new PropertyCard("title", "description", "affect");
        PropertyCard secondCard
                = new PropertyCard("title", "description", "affect");
        Assert.assertTrue(examples.overriddenEquals(firstCard, secondCard));
    }

    @Test
    public void NonOverriddenEquals_EqualBanks_False() {
        Map<Nominal, Integer> map = new HashMap<>();
        map.put(Nominal.FIFTY, 10);
        Assert.assertFalse(examples.nonOverriddenEquals(new NotRealBank(), new NotRealBank()));
        Assert.assertFalse(examples.nonOverriddenEquals(new NotRealBank(map),
                new NotRealBank(map)));
    }
}