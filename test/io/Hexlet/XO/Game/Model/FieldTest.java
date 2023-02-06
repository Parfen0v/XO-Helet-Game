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
}