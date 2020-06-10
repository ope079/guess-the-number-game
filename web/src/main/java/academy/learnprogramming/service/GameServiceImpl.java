package academy.learnprogramming.service;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {
    private final Game game;
    private final MessageGenerator message;

    @Autowired
    public GameServiceImpl(Game game, MessageGenerator message) {
        this.game = game;
        this.message = message;
    }

    @PostConstruct
    public void init() {
        log.info("the main message is {}", message.getMainMessage());
        log.info("the number you have guessed is {}", game.getNumber());
    }

    @Override
    public boolean isGameOver() {
        return game.isGameLost() || game.isGameWon();

    }

    @Override
    public String getMainMessage() {
        return message.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return message.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
