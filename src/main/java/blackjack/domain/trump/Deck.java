package blackjack.domain.trump;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Deck {
    private final Deque<Card> deck;

    private Deck(Deque<Card> deck) {
        this.deck = deck;
    }

    //TODO: 덱을 생성할 때 섞인 상태로 주는 것이 옳은가
    public static Deck of() {
        return new Deck(shuffle(createCards()));
    }

    private static Deque<Card> createCards() {
        Deque<Card> cards = new ArrayDeque<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(Card.of(rank, suit));
            }
        }
        return cards;
    }

    private static Deque<Card> shuffle(Deque<Card> cards) {
        List<Card> shuffledCards = new ArrayList<>(cards.stream().toList());
        Collections.shuffle(shuffledCards);
        return new ArrayDeque<>(shuffledCards);
    }

    public Card draw() {
        return deck.removeFirst();
    }

    public Deque<Card> getDeck() {
        return deck;
    }
}
