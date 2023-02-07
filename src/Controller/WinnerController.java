package Controller;

import io.Hexlet.XO.Game.Model.Exceptions.InvalidPointException;
import io.Hexlet.XO.Game.Model.Field;
import io.Hexlet.XO.Game.Model.Figure;

import java.awt.*;

public class WinnerController {
    public Figure getWinner (final Field field) {
        try {
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field,new Point(i,0), p -> new Point(p.x, p.y+1)))
                    return field.getFigure(new Point(i,0));
            }

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field,new Point(0,i), p -> new Point(p.x+1, p.y)))
                    return field.getFigure(new Point(0,i));
            }

            if (check(field,new Point(0,0), p -> new Point(p.x+1, p.y+1)))
                return field.getFigure(new Point(0,0));

            if (check(field,new Point(0,field.getSize()), p -> new Point(p.x+1, p.y-1)))
                return field.getFigure(new Point(0,field.getSize()));
        } catch (InvalidPointException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private boolean check (final Field field, final Point currentPoint, final IPointGenerator pointGenerator) {
        final Figure currentFigyre;
        final Figure nextFigyre;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigyre = field.getFigure(currentPoint);
            nextFigyre = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigyre == null) {
            return false;
        }

        if (currentFigyre != nextFigyre) {
            return false;
        }

        return check(field, nextPoint, pointGenerator );
    }

    private interface IPointGenerator {
        public Point next (final Point point);
    }
}
