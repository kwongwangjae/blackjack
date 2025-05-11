package blackjack.domain.table;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;

public class ScoreTable {
    private final Map<Participant, BigDecimal> scores = new LinkedHashMap<>();

    ScoreTable(Dealer dealer, List<Player> players) {
        scores.put(dealer, BigDecimal.ZERO);
        players.forEach(player -> scores.put(player, BigDecimal.ZERO));
    }

    public void updateScore(Participant participant, BigDecimal score) {
        scores.put(participant, scores.get(participant).add(score));
    }

    public Map<Participant, BigDecimal> getScores() {
        return Collections.unmodifiableMap(scores);
    }

}
