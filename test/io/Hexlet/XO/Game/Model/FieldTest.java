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
    void setFigure() throws InvalidPointException, PointAlreadyOccupiedException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    void testSetFigureWhenAlreadyAccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint,inputFigure);
        try {
            field.setFigure(inputPoint,inputFigure);
            fail();
        } catch (final PointAlreadyOccupiedException e) {}
    }

    @Test
    void testGetFigureWhenFigureIsNotSet() throws InvalidPointException, PointAlreadyOccupiedException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void testGetFigureWhenXIsMoreThenFieldSize() throws Exception {
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