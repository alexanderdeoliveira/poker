package com.musicplayce.poker.model;

import com.musicplayce.poker.util.EnumUtil;
import java.util.List;
import java.util.Random;

public class Card {
    private EnumUtil.Value value;
    private EnumUtil.Suit suit;

    Card(List<Card> cardsUnavailable) {
        Card card;
        do {
            card = generateCard();
        } while (cardsUnavailable.contains(card));
    }

    private Card generateCard() {
        Random valueGenerator = new Random();

        switch (valueGenerator.nextInt(13)) {
            case 0:
                this.value = EnumUtil.Value.TWO;
                break;

            case 1:
                this.value = EnumUtil.Value.THREE;
                break;

            case 2:
                this.value = EnumUtil.Value.FOUR;
                break;

            case 3:
                this.value = EnumUtil.Value.FIVE;
                break;

            case 4:
                this.value = EnumUtil.Value.SIX;
                break;

            case 5:
                this.value = EnumUtil.Value.SEVEN;
                break;

            case 6:
                this.value = EnumUtil.Value.EIGHT;
                break;

            case 7:
                this.value = EnumUtil.Value.NINE;
                break;

            case 8:
                this.value = EnumUtil.Value.TEN;
                break;

            case 9:
                this.value = EnumUtil.Value.JACK;
                break;

            case 10:
                this.value = EnumUtil.Value.QUEEN;
                break;

            case 11:
                this.value = EnumUtil.Value.KING;
                break;

            case 12:
                this.value = EnumUtil.Value.ACE;
                break;

        }

        Random suitGenerator = new Random();

        switch (suitGenerator.nextInt(4)) {
            case 0:
                this.suit = EnumUtil.Suit.CLUBS;
                break;

            case 1:
                this.suit = EnumUtil.Suit.DIAMONDS;
                break;

            case 2:
                this.suit = EnumUtil.Suit.HEARTS;
                break;

            case 3:
                this.suit = EnumUtil.Suit.SPADES;
                break;

        }

        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Card))
            return false;
        Card card = (Card)obj;
        return value == card.value && suit == card.suit;
    }

    public EnumUtil.Value getValue() {
        return value;
    }

    public void setValue(EnumUtil.Value value) {
        this.value = value;
    }

    public EnumUtil.Suit getSuit() {
        return suit;
    }

    public void setSuit(EnumUtil.Suit suit) {
        this.suit = suit;
    }
}
