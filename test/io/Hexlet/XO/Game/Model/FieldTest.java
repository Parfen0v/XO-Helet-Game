package io.Hexlet.XO.Game.Model;

import io.Hexlet.XO.Game.Model.Exceptions.InvalidPointException;
import io.Hexlet.XO.Game.Model.Exceptions.PointAlreadyOccupiedException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    void setFigure() throws InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    void testGetFigureWhenFigureIsNotSet() throws InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    void testGetFigureWhenXIsLessThenZero() {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenYIsLessThenZero() {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenXIsMoreThenFieldSize(){
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1 ,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenYIsMoreThenFieldSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize() + 1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
}