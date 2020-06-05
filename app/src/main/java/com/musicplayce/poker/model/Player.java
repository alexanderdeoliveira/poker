package com.musicplayce.poker.model;

import java.util.List;

public class Player {

    private String name;
    private Hand hand;

    public Player(String name, List<Card> cardsUnavailable) {
        this.hand = new Hand(cardsUnavailable);
        this.name = name;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
