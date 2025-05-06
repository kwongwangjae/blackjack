package blackjack.domain.table;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;

public class ScoreTable {
    private final Map<Participant, BigDecimal> scores = new HashMap<>();

    public ScoreTable(Dealer dealer, List<Player> players) {
        scores.put(dealer, BigDecimal.ZERO);
        players.forEach(player -> scores.put(player, BigDecimal.ZERO));
    }

}
