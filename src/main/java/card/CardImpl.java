package card;

public class CardImpl implements Card{

    private final Integer value;

    public CardImpl(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

}
