package blackjack.Controller;

import static blackjack.view.InputView.*;
import static blackjack.view.OutputView.*;

import java.math.BigDecimal;
import java.util.List;

import blackjack.service.BlackjackService;
import blackjack.view.InputView;

public class BlackjackController {
    private final BlackjackService service;

    public BlackjackController(BlackjackService service) {
        this.service = service;
    }

    public void run() {
        setUpGame();
        betting();
    }


    private void setUpGame() {
        String playerName = putPlayerName();
        service.setupGame(playerName);
        printBlankLine();
    }

    private void betting() {
        List<String> playerNames = service.getPlayerNames();

        for (String name : playerNames) {
            BigDecimal amount = InputView.putBet(name);
            service.tableBetting(name, amount);
            printBlankLine();
        }
    }

}
