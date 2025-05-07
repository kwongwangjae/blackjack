package blackjack.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import blackjack.domain.participant.Participant;

public class OutputView {
    public static void printBlankLine() {
        System.out.println();
    }

    public static void putSeparateCard(List<String> players) {
        System.out.println("딜러와 " + String.join(", ", players) + "에게 2장의 나누었습니다.");
    }

    public static void putDealerCard(String cardTitle) {
        System.out.printf("딜러: %s%n", cardTitle);
    }

    public static void putPlayerCard(String playerName, String cardTitles) {
        System.out.printf("%s카드: %s%n", playerName, cardTitles);
    }

    public static void putDealerHit() {
        System.out.println("딜러는 16이하라 한 장의 카드를 더 받았습니다.");
    }

    public static void putBust(String playerName) {
        System.out.printf("%s은(는) 21을 초과하여 패배 했습니다.%n", playerName);
    }

    public static void putResultLine(String participant, String cards, int score) {
        System.out.printf("%s 카드: %s - 결과: %d%n", participant , cards, score);
    }

    public static void putFinalScore(Map<Participant, BigDecimal> scoreTable) {
        System.out.println("## 최종 수익");
        for (var entry : scoreTable.entrySet()) {
            String participant = entry.getKey().getName();
            BigDecimal score = entry.getValue();
            System.out.printf("%s: %s%n", participant, score.toPlainString());
        }
    }


}
