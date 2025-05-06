package blackjack.domain.participant;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.domain.table.GameTable;

public class PlayerTest {

    @Test
    @DisplayName("배팅 금액은 0이상 이어야 한다.")
    void bettingMustBeOverZero() {
        Player player = Player.of("pobi");

        assertThrows(
                IllegalArgumentException.class,
                () -> player.betting(BigDecimal.ZERO)
        );
    }

    @Test
    @DisplayName("배팅 금액은 0이상 이어야 한다.")
    void bettingMustBePositive() {
        Player player = Player.of("pobi");

        assertThrows(
                IllegalArgumentException.class,
                () -> player.betting(BigDecimal.valueOf(-10))
        );
    }
}
