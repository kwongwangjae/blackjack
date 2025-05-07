package blackjack.domain.trump;

public enum Rank {
    ACE(1, 11, "A"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"),
    SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"),
    JACK(10, "J"), QUEEN(10, "Q"), KING(10, "K");

    private final int hardValue;
    private final int softValue;
    private final String title;

    Rank(int value, String title) {
        this(value, value, title);
    }

    Rank(int hardValue, int softValue, String title) {
        this.hardValue = hardValue;
        this.softValue = softValue;
        this.title = title;
    }

    int getHardValue() {
        return hardValue;
    }

    int getSoftValue() {
        return softValue;
    }

    String getTitle() {
        return title;
    }



}