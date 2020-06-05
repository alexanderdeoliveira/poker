package com.musicplayce.poker.presenter;

import com.musicplayce.poker.interfaces.GameContract;
import com.musicplayce.poker.model.Card;
import com.musicplayce.poker.model.Player;
import java.util.ArrayList;
import java.util.List;

public class GamePresenter implements GameContract.UserActionsListener {

    private GameContract.GameView gameView;

    public GamePresenter(GameContract.GameView gameView){
        this.gameView = gameView;
    }

    @Override
    public void initGame() {
        Player player1 = new Player("Player 1", new ArrayList<Card>());

        List<Card> cardsUnavailable = new ArrayList<>();
        cardsUnavailable.addAll(player1.getHand().getCards());
        Player player2 = new Player("Player 2", cardsUnavailable);

        gameView.showHands(player1, player2);

        int scorePlayer1 = player1.getHand().getScore();
        int scorePlayer2 = player2.getHand().getScore();

        if(scorePlayer1 > scorePlayer2)
            gameView.showWinner(player1);
        else
            gameView.showWinner(player2);

    }
}
