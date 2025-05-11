package blackjack.Controller;

import static blackjack.view.InputView.*;
import static blackjack.view.OutputView.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blackjack.domain.participant.Participant;
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
        Map<String, BigDecimal> bettings = new HashMap<>();

        for (String name : playerNames) {
            BigDecimal amount = putBet(name);
            bettings.put(name, amount);
            printBlankLine();
        }

        service.tableBetting(bettings);
    }

    private void separateCard() {
        List<String> playerNames = service.getPlayerNames();
        service.dealInitialCards();

        putSeparateCard(playerNames);
        putDealerCard(service.getDealerInitialCards());

        for (String name : playerNames) {
            putPlayerCard(name, service.getPlayerInitialCards(name));
        }
        printBlankLine();
    }

    public void playBlackjack() {
        if(service.isDealerBlackjack()){
            result();
        }
        else{
            for(String name : service.getPlayerNames()){
                while (putHit(name)) {
                    service.playerHit(name);
                    putPlayerCard(name, service.getPlayerInitialCards(name));
                }
            }

            if (service.shouldDealerHit()) {
                service.dealerHit();
                putDealerHit();
            }
            printBlankLine();
            result();
        }
    }


    public void result() {
        List<String> playerNames = service.getPlayerNames();
        putResultLine("딜러", service.getDealerInitialCards(), service.getDealerScore());

        for(String name : playerNames){
            putResultLine(name, service.getPlayerInitialCards(name), service.getPlayerScore(name));
        }

        printBlankLine();

        Map<Participant, BigDecimal> finalScores = service.calculateFinalScores();
        putFinalScore(finalScores);
    }





}
