package blackjack.domain.table;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;

public class GameTableTest {

    @Test
    @DisplayName("각 플레이어는 중복된 이름을 사용할 수 없다.")
    void playerNameMustBeUnique() {
        Dealer dealer = Dealer.of();
        List<Player> players = new ArrayList<>() {{
            add(Player.of("pobi"));
            add(Player.of("pobi"));
        }};

        assertThrows(
                IllegalArgumentException.class,
                () -> GameTable.of(dealer, players)
        );

    }


}
