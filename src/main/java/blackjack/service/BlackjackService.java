package blackjack.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.table.GameTable;

public class BlackjackService {

    public GameTable setupGame(String playerNames) {
        List<Player> players = Arrays.stream(playerNames.split(","))
                .map(String::trim)
                .map(Player::of)
                .collect(Collectors.toList());

        Dealer dealer = Dealer.of();
        return GameTable.of(dealer, players);
    }

    public void betting(Player player, BigDecimal bet) {
        player.betting(bet);
    }

    public void playGame(GameTable gameTable) {

    }

    public void endGame(GameTable gameTable) {
    }
}
