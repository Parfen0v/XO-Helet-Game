package io.Hexlet.XO.Game.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void getPlayers() {
        final Player[] inputValue = {new Player("Vasya",Figure.O), new Player("Petya", Figure.X)};
        final Player[] expectedValue = inputValue;

        final Game game = new Game(inputValue, null,null);

        final Player[] actualValye = game.getPlayers();

        assertEquals(expectedValue, actualValye);
    }

    @Test
    void getField() {

        final Field inputValue = new Field();
        final Field expectedValue = inputValue;

        final Game game = new Game(null, expectedValue,null);

        final Field actualValye = game.getField();

        assertEquals(expectedValue, actualValye);

    }

    @Test
    void getName() {

        final String inputValue = "one Game";
        final String expectedValue = inputValue;

        final Game game = new Game(null, null,expectedValue);

        final String actualValye = game.getName();

        assertEquals(expectedValue, actualValye);
    }
}