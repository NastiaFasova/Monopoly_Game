package monopoly;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MonopolyMockitoTest {
    @Mock
    private Player player;
    private Monopoly game = new Monopoly();

    @Test
    public void GetInfoAboutGame_ReturnsPlayers_Success() {
        game.setPlayers(List.of(player));
        when(player.getName()).thenReturn("Nazar");
        when(player.getChanceCard()).thenReturn(new ChanceCard());
        when(player.getPropertyCard()).thenReturn(new PropertyCard());
        Assert.assertEquals(List.of(player), game.getInfoAboutGame());
    }
}