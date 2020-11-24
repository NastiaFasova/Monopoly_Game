package monopoly.equals_hashcode;

import monopoly.Nominal;
import monopoly.NotRealBank;
import monopoly.PropertyCard;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashcodeExamplesTest {

    private HashcodeExamples examples = new HashcodeExamples();

    @Test
    public void NonOverriddenHash_EqualBanks_False() {
        Map<Nominal, Integer> map = new HashMap<>();
        map.put(Nominal.FIFTY, 10);
        Assert.assertFalse(examples.nonOverriddenHashOfTwoObjects(new NotRealBank(), new NotRealBank()));
        Assert.assertFalse(examples.nonOverriddenHashOfTwoObjects(new NotRealBank(map), new NotRealBank(map)));
    }

    @Test
    public void OverriddenHashcode_EqualCards_True() {
        PropertyCard firstCard
                = new PropertyCard("title", "description", "affect");
        PropertyCard secondCard
                = new PropertyCard("title", "description", "affect");
        Assert.assertTrue(examples.overriddenHashcode(firstCard, secondCard));
    }
}