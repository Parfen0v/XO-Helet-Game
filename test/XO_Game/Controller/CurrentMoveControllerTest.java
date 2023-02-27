package XO_Game.Controller;

import XO_Game.Model.Field;
import XO_Game.Model.Figure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionConfigurationException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {

    @Test
    public void testMoveControllerX() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.O);
            field.setFigure(new Point(i,1), Figure.X);
            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }
    }
    @Test
    public void testMoveControllerO() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.O);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.X);
            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }
    }
    @Test
    public void testMoveControllerNull() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(i,0), Figure.O);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.O);
        }
        assertNull(currentMoveController.currentMove(field));

    }
}