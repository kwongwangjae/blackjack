package blackjack.domain.participant;

public class Dealer extends Participant {

    private Dealer() {
        super("딜러");
    }

    public static Dealer of() {
        return new Dealer();
    }

}
