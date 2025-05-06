package blackjack.Controller;

import java.math.BigDecimal;

import blackjack.domain.participant.Player;
import blackjack.domain.table.GameTable;
import blackjack.service.BlackjackService;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackjackController {
    private final BlackjackService service;

    public BlackjackController(BlackjackService service) {
        this.service = service;
    }

    public void run() {
        setUpGame();
    }


    private void setUpGame() {
        String playerName = InputView.putPlayerName();
        GameTable table = service.setupGame(playerName);
        OutputView.printBlankLine();
        for (Player player : table.getPlayers()) {
            BigDecimal bet = InputView.putBet(player.getName());
            service.betting(player, bet);
            OutputView.printBlankLine();
        }
    }








}
