package blackjack.view;

import java.util.List;

public class OutputView {
    public static void printBlankLine() {
        System.out.println();
    }

    public static void putSeparateCard(List<String> players) {
        System.out.printf("딜러와 " + String.join(", ", players) + "에게 2장의 나누었습니다.%n");
    }

    public static void putDealerCard(String cardTitle) {
        System.out.printf("딜러: %s%n", cardTitle);
    }

    public static void putPlayerCard(String playerName, String cardTitles) {
        System.out.printf("%s카드: %s%n", playerName, cardTitles);
    }
}
