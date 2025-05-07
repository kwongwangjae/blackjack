package blackjack.domain.participant;

public class Dealer extends Participant {

    private Dealer() {
        super("딜러");
    }

    public static Dealer of() {
        return new Dealer();
    }

    @Override
    public String showInitialCards() {
        //TODO: 너무 복잡하게 설계 수정 방안을 마련해야 함 + 딜러에게 첫장 선택권 마련
        return getHand().getCards().get(0).getTitle();
    }
}
