package blackjack.domain.table;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;

public class ScoreTable {
    private final Map<Participant, BigDecimal> scores = new HashMap<>();

    ScoreTable(Dealer dealer, List<Player> players) {
        scores.put(dealer, BigDecimal.ZERO);
        players.forEach(player -> scores.put(player, BigDecimal.ZERO));
    }

    public void dealerBlackjack(List<Player> players) {
        BigDecimal dealerTotal = BigDecimal.ZERO;

        for (Player player : players) {
            BigDecimal bet = player.getBet();
            if (!player.getHand().isBlackjack()) {
                scores.put(player, scores.get(player).subtract(bet));
                dealerTotal = dealerTotal.add(bet);
            }
        }

        scores.put(scores.keySet().iterator().next(), scores.get(scores.keySet().iterator().next()).add(dealerTotal));
    }

    public Map<Participant, BigDecimal> getScores() {
        return Collections.unmodifiableMap(scores);
    }

}
