package blackjack.domain.participant;
import blackjack.domain.trump.Card;

public abstract class Participant {
    private final String name;
    private final Hand hand = new Hand();

    Participant(String name) {
        this.name = name;
    }

    public abstract String showInitialCards();

    public boolean isBlackJack() {
        return hand.isBlackjack();
    }

    public int calculateScore() {
        return getHand().getBestScore();
    }

    public String getName() {
        return name;
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public Hand getHand() {
        return hand;
    }


}
