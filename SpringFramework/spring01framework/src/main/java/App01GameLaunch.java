import game.GameRunner;
import game.PacmanGame;

public class App01GameLaunch {

    public static void main(String[] args) {

//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame();

        var gameRunner = new GameRunner(game);

        gameRunner.run();
    }
}
