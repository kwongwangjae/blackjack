package blackjack.Controller;

import static blackjack.view.InputView.*;
import static blackjack.view.OutputView.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;
import blackjack.service.BlackjackService;

public class BlackjackController {
    private final BlackjackService service;

    public BlackjackController(BlackjackService service) {
        this.service = service;
    }

    public void run() {
        setUpGame();
        betting();
        separateCard();
        playBlackjack();
    }


    private void setUpGame() {
        String playerName = putPlayerName();
        service.setupGame(playerName);
        printBlankLine();
    }

    private void betting() {
        List<String> playerNames = service.getPlayerNames();

        for (String name : playerNames) {
            BigDecimal amount = putBet(name);
            service.tableBetting(name, amount);
            printBlankLine();
        }
    }

    private void separateCard() {
        List<String> playerNames = service.getPlayerNames();
        service.dealInitialCards();
        putSeparateCard(playerNames);

        String dealerCard = service.getDealerInitialCards();
        putDealerCard(dealerCard);

        for (String name : playerNames) {
            String cards = service.getPlayerInitialCards(name);
            putPlayerCard(name, cards);
        }
    }

    public void playBlackjack() {
    }





}
