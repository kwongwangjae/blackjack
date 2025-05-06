package blackjack.domain;

public enum Rank {
    ACE(1, 11), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10), QUEEN(10), KING(10);

    private final int hardValue;
    private final int softValue;

    Rank(int value) {
        this(value, value);
    }

    Rank(int hardValue, int softValue) {
        this.hardValue = hardValue;
        this.softValue = softValue;
    }

    int getHardValue() {
        return hardValue;
    }

    int getSoftValue() {
        return softValue;
    }


}