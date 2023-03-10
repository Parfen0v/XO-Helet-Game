package XO_Game.Model;

import XO_Game.Model.Exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    public static int fieldSize = 3;

    @Test
    void getSize() {
        final Field field = new Field(fieldSize);

        assertEquals(3, field.getSize());
    }

    @Test
    void setFigure() throws InvalidPointException {
        final Field field = new Field(fieldSize);
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    void testGetFigureWhenFigureIsNotSet() throws InvalidPointException {
        final Field field = new Field(fieldSize);
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    void testGetFigureWhenXIsLessThenZero() {
        final Field field = new Field(fieldSize);
        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenYIsLessThenZero() {
        final Field field = new Field(fieldSize);
        final Point inputPoint = new Point(0,-1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenXIsMoreThenFieldSize(){
        final Field field = new Field(fieldSize);
        final Point inputPoint = new Point(field.getSize() + 1 ,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenYIsMoreThenFieldSize() throws Exception {
        final Field field = new Field(fieldSize);
        final Point inputPoint = new Point(0,field.getSize() + 1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
}