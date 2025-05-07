package blackjack.domain.trump;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckTest {
    @Test
    @DisplayName("카드 덱은 52장의 포커 카드를 들고 있어야 한다.")
    void deckSizeAreFiftyTwo() {
        Deck deck = Deck.of();

        int size = deck.getDeck().size();

        assertEquals(52, size);
    }

}
