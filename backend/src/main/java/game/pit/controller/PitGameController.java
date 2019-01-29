package game.pit.controller;

import game.pit.service.PitGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PitGameController {

    @Autowired
    PitGameService service;
    // private static final Logger LOG =
    // Logger.getLogger(PitGameController.class.getName());

    @RequestMapping(value = "/game", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity getGame() {

        return ResponseEntity.ok(service.getGame());
        // return new ResponseEntity<>(service.getGame(), HttpStatus.OK);
    }

    @RequestMapping(value = "/gamestart/{gamestart}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity setStartGame(@PathVariable("gamestart") boolean gamestart) {
        service.setGameStarted(gamestart);

        return new ResponseEntity(service.isGameStarted(), HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/isgamestarted", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity getStartGame() {

        return ResponseEntity.ok(service.isGameStarted());

    }

    @RequestMapping(value = "/isgameend", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity getIsGameEnded() {

        return ResponseEntity.ok(service.isGameEnd());

    }

    @RequestMapping(value = "/playerturn", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity getPlayerTurn() {

        return ResponseEntity.ok(service.getPlayerTurn());
    }

    @RequestMapping(value = "/playerturn/{playerturn}", method = RequestMethod.POST)
    public ResponseEntity setPlayerTurn(@PathVariable("playerturn") int playerTurn) {
        service.setPlayerTurn(playerTurn);
        return new ResponseEntity(service.getPlayerTurn(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/gamestate/{playerid}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity getPlayerGameState(@PathVariable("playerid") int playerId) {
        if (playerId == 1) {
            return ResponseEntity.ok(service.getPlayer1GameState());
        }
        if (playerId == 2) {
            return ResponseEntity.ok(service.getPlayer2GameState());
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
