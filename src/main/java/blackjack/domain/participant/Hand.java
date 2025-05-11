package blackjack.domain.participant;

import java.util.ArrayList;
import java.util.List;

import blackjack.domain.trump.Card;
import blackjack.domain.trump.Rank;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    void addCard(Card card) {
        cards.add(card);
    }

    List<Card> getCards() {
        return cards;
    }

    int getBestScore() {
        if (!hasAce()) {
            return getHardTotal();
        }
        int soft = getSoftTotal();
        return (soft <= 21) ? soft : getHardTotal();
    }

    boolean isBlackjack() {
        return cards.size() == 2 && getBestScore() == 21;
    }

    private boolean hasAce() {
        return cards.stream().anyMatch(c -> c.getRank() == Rank.ACE);
    }

    private int getHardTotal() {
        return cards.stream()
                .mapToInt(Card::getHardValue)
                .sum();
    }

    private int getSoftTotal() {
        return cards.stream()
                .mapToInt(Card::getSoftValue)
                .sum();
    }


}
