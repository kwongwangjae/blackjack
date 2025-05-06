package blackjack.view;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String putPlayerName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return scanner.nextLine().trim();
    }

    public static BigDecimal putBet(String playerName) {
        System.out.printf("%s의 배팅 금액은?%n", playerName);
        return new BigDecimal(scanner.nextLine().trim());
    }


}
