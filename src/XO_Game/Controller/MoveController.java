package XO_Game.Controller;

import XO_Game.Model.Exceptions.InvalidPointException;
import XO_Game.Model.Exceptions.PointAlreadyOccupiedException;
import XO_Game.Model.Field;
import XO_Game.Model.Figure;

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
