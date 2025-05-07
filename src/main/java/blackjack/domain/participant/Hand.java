package blackjack.domain.participant;

import java.util.ArrayList;
import java.util.List;

import blackjack.domain.trump.Card;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

}
