package blackjack.domain;

public class Card {
    private final Rank rank;
    private final Suit suit;

    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card of(Rank rank, Suit suit) {
        return new Card(rank, suit);
    }

    public int getRankValue() {
        return rank.getValue();
    }

    public int getAceValue() {
        return rank.getAceValue();
    }

}
