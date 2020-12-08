package monopoly;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {
    @Mock
    private PropertyCard propertyCard;
    @Mock
    private ChanceCard chanceCard;
    private Player player;

    @Test
    public void GetInfoAboutPlayer_ReturnsListOfCards_Success() {
        player = new Player("Ihor");
        player.setPropertyCards(List.of(propertyCard));
        player.setChanceCards(List.of(chanceCard));
        when(propertyCard.getDescription()).thenReturn("A street.");
        when(chanceCard.getDescription()).thenReturn("Taxes!");
        Assert.assertEquals(List.of(propertyCard, chanceCard), player.getInfoAboutPlayer());
    }
}