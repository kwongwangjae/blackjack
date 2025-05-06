package blackjack;

import blackjack.Controller.BlackjackController;
import blackjack.service.BlackjackService;

public class Blackjack {
    public static void main(String[] args) {
        BlackjackController controller = new BlackjackController(new BlackjackService());
        controller.run();
    }
}
