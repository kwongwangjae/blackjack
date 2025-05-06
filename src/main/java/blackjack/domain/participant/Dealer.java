package blackjack.domain.participant;

import blackjack.domain.trump.Deck;

public class Dealer extends Participant {

    private final Deck deak;

    private Dealer() {
        super("딜러");
        this.deak = Deck.of();
    }

    public static Dealer of() {
        return new Dealer();
    }

}
