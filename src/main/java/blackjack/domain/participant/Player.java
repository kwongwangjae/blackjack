package blackjack.domain.participant;

public class Player extends Participant {

    private Player(String name) {
        super(name);
    }

    public static Player of(String name) {
        return new Player(name);
    }

}
