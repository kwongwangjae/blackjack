package blackjack.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
    private final Deque<Card> cards;

    Deck() {
        cards = Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Rank.values())
                        .map(r -> Card.of(r, s))).collect(Collectors.toCollection(ArrayDeque::new));
    }

    public static Deck of() {
        return new Deck();
    }

    public Deque<Card> getCards() {
        return cards;
    }

}
