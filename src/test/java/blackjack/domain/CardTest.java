package blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("Ace는 1 또는 11로 계산할 수 있다.")
    void aceValueOptions() {
        Card ace = Card.of(Rank.ACE, Suit.CLUBS);
        assertEquals(1, ace.getHardValue());
        assertEquals(11, ace.getSoftValue());
    }

    @Test
    @DisplayName("King, Queen, Jack은 각각 10으로 계산한다.")
    void faceCardsAreTen() {
        assertEquals(10, Card.of(Rank.KING,  Suit.HEARTS).getHardValue());
        assertEquals(10, Card.of(Rank.QUEEN, Suit.SPADES).getHardValue());
        assertEquals(10, Card.of(Rank.JACK,  Suit.DIAMONDS).getHardValue());
    }

    @Test
    @DisplayName("숫자 카드는 해당 숫자 값으로 계산한다.")
    void numberCardsHaveNumericValue() {
        assertEquals(2,  Card.of(Rank.TWO,   Suit.HEARTS).getHardValue());
        assertEquals(7,  Card.of(Rank.SEVEN, Suit.CLUBS).getHardValue());
        assertEquals(10, Card.of(Rank.TEN,   Suit.SPADES).getHardValue());
    }

}
