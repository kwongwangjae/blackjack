package blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("Ace는 1 또는 11로 계산할 수 있다.")
    void aceValueOptions() {
        Card ace = Card.of(Rank.ACE, Suit.CLUBS);
        assertEquals(1, ace.getRankValue());
        assertEquals(11, ace.getAceValue());
    }

    @Test
    @DisplayName("King, Queen, Jack은 각각 10으로 계산한다.")
    void faceCardsAreTen() {
        assertEquals(10, Card.of(Rank.KING,  Suit.HEARTS).getRankValue());
        assertEquals(10, Card.of(Rank.QUEEN, Suit.SPADES).getRankValue());
        assertEquals(10, Card.of(Rank.JACK,  Suit.DIAMONDS).getRankValue());
    }

    @Test
    @DisplayName("숫자 카드는 해당 숫자 값으로 계산한다.")
    void numberCardsHaveNumericValue() {
        assertEquals(2,  Card.of(Rank.TWO,   Suit.HEARTS).getRankValue());
        assertEquals(7,  Card.of(Rank.SEVEN, Suit.CLUBS).getRankValue());
        assertEquals(10, Card.of(Rank.TEN,   Suit.SPADES).getRankValue());
    }

}
