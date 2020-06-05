package com.musicplayce.poker.interfaces;

import com.musicplayce.poker.model.Player;

public interface GameContract {

    interface GameView {
        void showHands(Player player1, Player player2);
        void showWinner(Player playerWinner);
    }

    interface UserActionsListener {

        void initGame();
    }
}
