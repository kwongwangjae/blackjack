package blackjack.domain.participant;

import java.util.ArrayList;
import java.util.List;

import blackjack.domain.trump.Card;
import blackjack.domain.trump.Rank;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getBestScore() {
        int soft = getSoftTotal();
        return (soft <= 21) ? soft : getHardTotal();
    }

    public boolean isBlackjack() {
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
        int hard = getHardTotal();
        if (hasAce()) {
            return hard + 10;
        }
        return hard;
    }


}
