package blackjack.domain.participant;

public abstract class Participant {
    private final String name;

    Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
