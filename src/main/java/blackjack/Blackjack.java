package blackjack;

import blackjack.Controller.BlackjackController;
import blackjack.service.BlackjackService;

public class Blackjack {
    public static void main(String[] args) {
        BlackjackService service = new BlackjackService();
        BlackjackController controller = new BlackjackController(service);
        controller.run();
    }
}
