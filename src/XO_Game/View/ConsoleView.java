package XO_Game.View;

import XO_Game.Controller.CurrentMoveController;
import XO_Game.Controller.MoveController;
import XO_Game.Controller.WinnerController;
import XO_Game.Model.Exceptions.InvalidPointException;
import XO_Game.Model.Exceptions.PointAlreadyOccupiedException;
import XO_Game.Model.Field;
import XO_Game.Model.Figure;
import XO_Game.Model.Game;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();
    public void show(final Game game) {
        System.out.printf("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            printLine(field, x);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.printf("Winner is %s", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);

        if (currentFigure == null) {
            if (winner == null) {
                System.out.println("No winner and no moves left!");
                return false;
            }
        }
        System.out.format("Please enter move point for: %s, from 1 to %s\n", currentFigure, field.getSize());
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | PointAlreadyOccupiedException e) {
            //e.printStackTrace();
            System.out.println("Point is inavlid!");
        }
        System.out.println();
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please Input %s", coordinateName);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("O_O ololol!!!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field, final int x) {
        if (x != 0)
            printSeparator(field);
        System.out.println();
        for (int y = 0; y < field.getSize(); y++) {
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure :  " ");
            System.out.print(" ");
            if (y != field.getSize() - 1)
                System.out.print("|");
        }
        System.out.println();
    }

    private void printSeparator (final Field field) {
        System.out.print("-");
        for (int i = 0; i < field.getSize(); i++) {
            System.out.print("---");
        }
        System.out.print("-");
    }

}
