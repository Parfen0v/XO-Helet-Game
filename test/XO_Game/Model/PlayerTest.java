package XO_Game.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void getName() {
        final String inputValue = "Dimon";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actualValye = player.getName();

        assertEquals(expectedValue, actualValye);
    }

    @Test
    void getFigure() {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValye = player.getFigure();

        assertEquals(expectedValue, actualValye);
    }
}