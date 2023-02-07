package Controller;

import io.Hexlet.XO.Game.Model.Exceptions.InvalidPointException;
import io.Hexlet.XO.Game.Model.Exceptions.PointAlreadyOccupiedException;
import io.Hexlet.XO.Game.Model.Field;
import io.Hexlet.XO.Game.Model.Figure;

import java.awt.*;

public class MoveController {
    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointException,
                                                        PointAlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new PointAlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
