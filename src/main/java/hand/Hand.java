package hand;

import card.Card;
import visitor.HandVisitor;

import java.util.List;

public interface Hand {

    List<Card> getCards();

    <T> T accept(HandVisitor<T> visitor);
}
