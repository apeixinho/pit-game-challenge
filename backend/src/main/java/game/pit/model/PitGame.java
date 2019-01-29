package game.pit.model;

//import java.io.Serializable;
public class PitGame {

    private boolean gameStarted;
    private boolean gameEnd;
    
    private int[][] game; //= new int[][]{{6, 6, 6, 6, 6, 6, 0}, {6, 6, 6, 6, 6, 6, 0}};
    private int playerTurn = getRandomPlayerTurn();

    public PitGame() {

        this.gameStarted = false;
        this.game = new int[][]{{6, 6, 6, 6, 6, 6, 0}, {6, 6, 6, 6, 6, 6, 0}};
    }

//    public void player1MakeMove(int origin) {
//
//        if (origin >= 0 && origin < 6) {
//
//            switch (origin) {
//
//            case 0:
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//
//            }
//
//            for (int i = origin; i < (player1.length - 1); i++) {
//                if (player1[origin] > 0) {
//                    player1[origin] = player1[origin] - 1;
//                    player1[origin + 1] = player1[origin + 1] + 1;
//                }
//
//            }
//
//        }
//
//    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    public int[][] getGame() {
        return game;
    }

    public void setGame(int[][] game) {
        this.game = game;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    private int getRandomPlayerTurn() {

        return Math.random() < 0.5 ? 1 : 2;
    }

}
