package blackjack.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;
import blackjack.domain.table.GameTable;
//TODO: DTO 사용
public class BlackjackService {
    private GameTable gameTable;

    public void setupGame(String playerNames) {
        List<Player> players = Arrays.stream(playerNames.split(","))
                .map(String::trim)
                .map(Player::of)
                .collect(Collectors.toList());

        gameTable = GameTable.of(Dealer.of(), players);
    }

    public void tableBetting(Map<String, BigDecimal> bettings) {
        gameTable.tableBetting(bettings);
    }


    public void dealInitialCards() {
        gameTable.dealInitialCards();
    }

    public boolean isDealerBlackjack() {
        return gameTable.getDealer().isBlackJack();
    }

    public boolean shouldDealerHit() {
        return gameTable.getDealer().calculateScore() < 17;
    }

    public void playerHit(String name) {
        Participant participant = getPlayer(name);
        gameTable.dealHit(participant);
    }

    public void dealerHit() {
        gameTable.dealHit(gameTable.getDealer());
    }

    public Map<Participant, BigDecimal> calculateFinalScores() {
        gameTable.result();

        return gameTable.getScoreTable()
                .getScores()
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a,b)->a,
                        LinkedHashMap::new
                ));
    }

    public String getDealerInitialCards() {
        return gameTable.showDealerCard();
    }

    public int getDealerScore() {
        return gameTable.getDealer().calculateScore();
    }

    public int getPlayerScore(String playerName) {
        return getPlayer(playerName)
                .calculateScore();
    }

    public String getPlayerInitialCards(String playerName) {
        return gameTable.showPlayerCards(
                getPlayer(playerName)
        );
    }

    public List<String> getPlayerNames() {
        return gameTable.getPlayerNames();
    }

    private Player getPlayer(String playerName) {
        return gameTable.getPlayers().stream()
                .filter(p -> p.getName().equals(playerName))
                .findFirst()
                .get();
    }

}
