package hand;

import card.Card;
import card.CardImpl;
import visitor.HandVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandImpl implements Hand {
    private final List<Card> cards;

    public HandImpl(Integer... values) throws HandCreationException {
        if(values.length > 7) throw new HandCreationException("Hand cannot contain more than 7 cards");
        this.cards = new ArrayList<>();

        Arrays.stream(values)
                .map(CardImpl::new)
                .forEach(this.cards::add);
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public <T> T accept(HandVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
