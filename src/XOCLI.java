import XO_Game.Model.Field;
import XO_Game.Model.Figure;
import XO_Game.Model.Game;
import XO_Game.Model.Player;
import XO_Game.View.ConsoleView;

public class XOCLI {
    public static void main(String[] args) {
        final String name1 = "Dimon";
        final String name2 = "Piter";
        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }
}
