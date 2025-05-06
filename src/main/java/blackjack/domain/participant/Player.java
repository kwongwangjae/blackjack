package blackjack.domain.participant;

import java.math.BigDecimal;

public class Player extends Participant {
    private BigDecimal bet;

    private Player(String name) {
        super(name);
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public void betting(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("베팅 금액은 0보다 커야 합니다. ");
        }
        if (amount.stripTrailingZeros().scale() > 0) {
            throw new IllegalArgumentException("베팅 금액은 정수여야 합니다. ");
        }

        bet = amount;
    }

    public BigDecimal getBet() {
        return bet;
    }

}
