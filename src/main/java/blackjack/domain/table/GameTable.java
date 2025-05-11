package blackjack.domain.table;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
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

    public void tableBetting(Map<String, BigDecimal> bettings) {
        for (Player player : players) {
            BigDecimal amount = bettings.get(player.getName());
            if (amount == null) {
                throw new IllegalArgumentException(player.getName() + "의 베팅금액이 존재하지 않습니다.");
            }
            player.betting(amount);
        }
    }

    public void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.receiveCard(deck.draw());
            }
            dealer.receiveCard(deck.draw());
        }
    }

    public void dealHit(Participant participant) {
        participant.receiveCard(deck.draw());
    }

    //TODO: 변경 필요
    public void result() {
        for (Player player : players) {
            BigDecimal bet = player.getBet();
            if (dealer.calculateScore() > 21 && player.calculateScore() > 21) {
                scoreTable.updateScore(player, BigDecimal.ZERO);
                scoreTable.updateScore(dealer, BigDecimal.ZERO);
            } else if (player.calculateScore() > 21) {
                scoreTable.updateScore(player, bet.negate());
                scoreTable.updateScore(dealer, bet);
            } else if (dealer.calculateScore() > 21) {
                scoreTable.updateScore(player, bet);
                scoreTable.updateScore(dealer, bet.negate());
            } else if (dealer.calculateScore() > player.calculateScore()) {
                scoreTable.updateScore(dealer, bet);
                scoreTable.updateScore(player, bet.negate());
            } else if (!dealer.isBlackJack() && player.isBlackJack()) {
                BigDecimal payout = bet.multiply(BigDecimal.valueOf(3))
                        .divide(BigDecimal.valueOf(2), 1, RoundingMode.HALF_UP);
                scoreTable.updateScore(player, payout);
                scoreTable.updateScore(dealer, payout.negate());
            } else if (dealer.calculateScore() < player.calculateScore()) {
                scoreTable.updateScore(player, bet);
                scoreTable.updateScore(dealer, bet.negate());
            } else {
                scoreTable.updateScore(player, BigDecimal.ZERO);
                scoreTable.updateScore(dealer, BigDecimal.ZERO);
            }
        }
    }


    public String showDealerCard() {
        return dealer.showInitialCards();
    }

    public String showPlayerCards(Player player) {
        return player.showInitialCards();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
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

    public Dealer getDealer() {
        return dealer;
    }

    public ScoreTable getScoreTable() {
        return scoreTable;
    }

}
