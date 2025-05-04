package blackjack.domain;

public enum Rank {
    ACE(1, 11), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10), QUEEN(10), KING(10);

    private final int value;
    private final int aceValue;

    Rank(int value) {
        this(value, value);
    }

    Rank(int value, int aceValue) {
        this.value = value;
        this.aceValue = aceValue;
    }

    int getValue() {
        return value;
    }

    int getAceValue() {
        return aceValue;
    }


}