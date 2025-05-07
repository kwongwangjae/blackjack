package blackjack.domain.table;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.trump.Deck;

public class GameTable {
    private final Dealer dealer;
    private final List<Player> players;
    private final ScoreTable scoreTable;
    private final Deck deck;

    private GameTable(Dealer dealer, List<Player> players) {
        this.dealer = dealer;
        this.players = players;
        this.scoreTable = new ScoreTable(dealer, players);
        this.deck = Deck.of();
    }

    public static GameTable of(Dealer dealer, List<Player> players) {
        validationPlayer(players);
        validationDealer(dealer);
        return new GameTable(dealer, players);
    }

    private static void validationPlayer(List<Player> players) {
        if(players.isEmpty()){
            throw new IllegalArgumentException("최소한 플레이어 한 명은 존재해야 합니다.");
        }

        if (players.stream().map(Player::getName).distinct().count() != players.size()) {
            throw new IllegalArgumentException("중복된 플레이어 이름이 있습니다.");
        }
    }

    private static void validationDealer(Dealer dealer) {
        if(!dealer.getName().equals("딜러")) throw new IllegalArgumentException("딜러의 이름은 딜러여야 합니다.");
    }

    public void tableBetting(String playerName, BigDecimal amount) {
        Player player = players.stream()
                .filter(p -> p.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("플레이어가 존재하지 않습니다."));
        player.betting(amount);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public ScoreTable getScoreTable() {
        return scoreTable;
    }
}
