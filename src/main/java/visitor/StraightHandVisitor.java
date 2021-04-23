package visitor;

import card.Card;
import hand.Hand;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StraightHandVisitor implements HandVisitor<Boolean> {

    private static StraightHandVisitor instance = null;

    private StraightHandVisitor() {}

    public static StraightHandVisitor create() {
        if(instance == null) instance = new StraightHandVisitor();
        return instance;
    }

    @Override
    public Boolean visit(Hand hand) {
        List<Integer> cards = hand.getCards().stream()
                .map(Card::getValue)
                .collect(Collectors.toList());


        long amountOfAS = cards.stream()
                .filter(num -> num == 14)
                .count();

        for (int i = 0; i < amountOfAS; i++) {
            cards.add(1);
        }

        Collections.sort(cards);

        int amountOfConsecutive = 0;
        for (int i = 1; i < cards.size(); i++) {

            if (cards.get(i) == cards.get(i-1) + 1) {
                amountOfConsecutive++;
            }

        }

        return amountOfConsecutive >= 4;
    }
}
