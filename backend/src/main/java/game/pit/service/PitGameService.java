package game.pit.service;

public interface PitGameService {

    public boolean isGameStarted();

    public void setGameStarted(boolean gameStarted);

    public boolean isGameEnd();

    public void setGameEnd(boolean gameEnd);

    public int[][] getGame();

    public void setGame(int[][] game);

    public int getPlayerTurn();

    public void setPlayerTurn(int playerTurn);
    
    public int[] getPlayer1GameState();
    
    public int[] getPlayer2GameState();
}
