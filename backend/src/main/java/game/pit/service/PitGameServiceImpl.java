package game.pit.service;

import game.pit.model.PitGame;
//import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PitGameServiceImpl implements PitGameService {

//    private static final Logger LOG = Logger.getLogger(PitGameServiceImpl.class.getName());
    private static PitGame pitgame = new PitGame();

    @Override
    public boolean isGameStarted() {
        return pitgame.isGameStarted();
    }

    @Override
    public void setGameStarted(boolean gameStarted) {
        pitgame.setGameStarted(gameStarted);
    }

    @Override
    public boolean isGameEnd() {
        return pitgame.isGameEnd();
    }

    @Override
    public void setGameEnd(boolean gameEnd) {
        pitgame.setGameEnd(gameEnd);
    }

    @Override
    public int getPlayerTurn() {
        return pitgame.getPlayerTurn();
    }

    @Override
    public void setPlayerTurn(int playerTurn) {
        pitgame.setPlayerTurn(playerTurn);
    }

    @Override
    public int[][] getGame() {
        return pitgame.getGame();
    }

    @Override
    public void setGame(int[][] game) {
        pitgame.setGame(game);
    }

    @Override
    public int[] getPlayer1GameState() {
        return pitgame.getGame()[0];

    }

    @Override
    public int[] getPlayer2GameState() {
        return pitgame.getGame()[1];
    }

}
