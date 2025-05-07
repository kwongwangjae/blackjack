package blackjack.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.table.GameTable;

public class BlackjackService {
    private GameTable gameTable;

    public void setupGame(String playerNames) {
        List<Player> players = Arrays.stream(playerNames.split(","))
                .map(String::trim)
                .map(Player::of)
                .collect(Collectors.toList());

        gameTable = GameTable.of(Dealer.of(), players);
    }

    public void tableBetting(String playerName, BigDecimal amount) {
        gameTable.tableBetting(playerName, amount);
    }

    public void dealInitialCards() {
        gameTable.dealInitialCards();
    }

    public String getDealerInitialCards() {
        return gameTable.showDealerCard();
    }

    public String getPlayerInitialCards(String playerName) {
        return gameTable.showPlayerCards(
                gameTable.getPlayers().stream()
                        .filter(p -> p.getName().equals(playerName))
                        .findFirst()
                        .get()
        );
    }

    public List<String> getPlayerNames() {
        return gameTable.getPlayerNames();
    }

}
