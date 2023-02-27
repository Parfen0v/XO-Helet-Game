package XO_Game.Controller;

import XO_Game.Controller.WinnerController;
import XO_Game.Model.Field;
import XO_Game.Model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class WinnerControllerTest {
    public static int fieldSize = 3;
    @Test
    void getWinnerWhenWinnerRow() throws Exception{
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);

            for (int j = 0; j < fieldSize; j++) {
                field.setFigure(new Point(i, j), Figure.X);
            }
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerWhenNoWinnerRow() throws Exception{
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(3);

            for (int j = 0; j < fieldSize - 1; j++) {
                field.setFigure(new Point(i, 0), Figure.X);
            }
            field.setFigure(new Point(i, fieldSize - 1 ), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerWhenNoWinnerRow2() throws Exception{
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.O);
            for (int j = 1; j < fieldSize ; j++) {
                field.setFigure(new Point(i, 0), Figure.X);
            }
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerWhenWinnerColumn() throws Exception{
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);

            for (int j = 0; j < fieldSize; j++) {
                field.setFigure(new Point(j, i), Figure.X);
            }
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(3);

            for (int j = 0; j < fieldSize - 1; j++) {
                field.setFigure(new Point(j, i), Figure.X);
            }
            field.setFigure(new Point(fieldSize - 1, i), Figure.O);

            assertNull(winnerController.getWinner(field));
        }
    }
}