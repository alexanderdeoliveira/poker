package com.musicplayce.poker.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand(List<Card> cardsUnavailable) {
        this.cards = new ArrayList<>();
        for(int i = 0;i<5;i++) {
            Card card = new Card(cardsUnavailable);
            cards.add(card);
            cardsUnavailable.add(card);
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getScore() {
        int[] valueCounts = new int[13];
        int flushSuit = getCards().get(0).getSuit().getSuitType();
        for (Card card : getCards()) {
            valueCounts[card.getValue().getValue()]++;
            if (card.getSuit().getSuitType() != flushSuit)
                flushSuit = -1;
        }

        int[] valueCountHist = new int[6];
        for (int count : valueCounts)
            valueCountHist[count]++;

        int bestCards = get5FrequentHighestCards(valueCounts, valueCountHist);
        int straightHighRank = getStraightHighRank(valueCounts);

        if      (straightHighRank != -1 && flushSuit != -1     ) return 8 << 20 | straightHighRank;
        else if (valueCountHist[4] == 1                         ) return 7 << 20 | bestCards;
        else if (valueCountHist[3] == 1 && valueCountHist[2] == 1) return 6 << 20 | bestCards;
        else if (flushSuit != -1                               ) return 5 << 20 | bestCards;
        else if (straightHighRank != -1                        ) return 4 << 20 | straightHighRank;
        else if (valueCountHist[3] == 1                         ) return 3 << 20 | bestCards;
        else if (valueCountHist[2] == 2                         ) return 2 << 20 | bestCards;
        else if (valueCountHist[2] == 1                         ) return 1 << 20 | bestCards;
        else                                                     return 0 << 20 | bestCards;
    }

    private static int getStraightHighRank(int[] values) {
        out:
        for (int i = values.length - 1; i >= 3; i--) {
            for (int j = 0; j < 5; j++) {
                if (values[(i - j + 13) % 13] == 0)
                    continue out;
            }
            return i;
        }
        return -1;
    }

    private int get5FrequentHighestCards(int[] values, int[] valuesHist) {
        int result = 0;
        int count = 0;

        for (int i = valuesHist.length - 1; i >= 0; i--) {
            for (int j = values.length - 1; j >= 0; j--) {
                if (values[j] == i) {
                    for (int k = 0; k < i && count < 5; k++, count++)
                        result = result << 4 | j;
                }
            }
        }

        return result;
    }
}
