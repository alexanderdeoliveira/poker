package com.musicplayce.poker.util;

public class EnumUtil {
    public enum Suit {
        CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);

        private final int type;
        Suit(int typeSuit){
            type = typeSuit;
        }
        public int getSuitType(){
            return type;
        }
    }

    public enum Value {
        TWO(0, "2"), THREE(1, "3"), FOUR(2, "4"), FIVE(3, "5"), SIX(4, "6"), SEVEN(5, "7"), EIGHT(6, "8"), NINE(7, "9"), TEN(8, "10"), JACK(9, "J"), QUEEN(10, "Q"), KING(11, "K"), ACE(12, "A");

        private final int value;
        private final String text;

        Value(int value, String text){
            this.value = value;
            this.text = text;
        }

        public int getValue(){
            return value;
        }

        public String getText() {
            return text;
        }
    }
}
