package blackjack.domain;

public class Card {
    private final Rank rank;
    private final Suit suit;

    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card of(Rank rank, Suit suit) {
        return new Card(rank, suit);
    }

    public int getHardValue() {
        return rank.getHardValue();
    }

    public int getSoftValue() {
        return rank.getSoftValue();
    }

    public String getSuitTitle() {
        return suit.getTitle();
    }

}
