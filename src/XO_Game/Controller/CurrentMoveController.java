package XO_Game.Controller;

import XO_Game.Model.Exceptions.InvalidPointException;
import XO_Game.Model.Field;
import XO_Game.Model.Figure;

import java.awt.*;

public class CurrentMoveController {
    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            countFigure += countFigureInRow(field, i);
        }

        if (countFigure== field.getSize() * field.getSize())
            return null;

        if (countFigure % 2 == 0)
            return Figure.X;
        return Figure.O;
    }

    private int countFigureInRow(final Field field,int row) {
        int countFigure = 0;
        for (int j = 0; j < field.getSize(); j++) {
            try {
                if (field.getFigure(new Point(row, j)) != null)
                    countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }
}
