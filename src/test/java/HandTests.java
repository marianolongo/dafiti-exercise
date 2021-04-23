import hand.Hand;
import hand.HandCreationException;
import hand.HandImpl;
import org.junit.Test;
import visitor.HandVisitor;
import visitor.StraightHandVisitor;
import static org.junit.Assert.assertEquals;

public class HandTests {

    @Test
    public void test_01_checkIfHandsAreStraight() throws HandCreationException {
        HandVisitor<Boolean> visitor = StraightHandVisitor.create();

        Hand hand1 = new HandImpl(14, 3, 2, 5, 4);
        Hand hand2 = new HandImpl(2, 3, 14, 5, 4);
        Hand hand3 = new HandImpl(2, 3, 14, 5, 4, 9, 12);
        Hand hand4 = new HandImpl(4, 10, 11, 13, 14, 12);
        Hand hand5 = new HandImpl(14, 3, 2 , 6, 4);
        Hand hand6 = new HandImpl(14, 2, 2, 5, 4);
        Hand hand7 = new HandImpl(14, 2, 3);

        assertEquals(true, visitor.visit(hand1));
        assertEquals(true, visitor.visit(hand2));
        assertEquals(true, visitor.visit(hand3));
        assertEquals(true, visitor.visit(hand4));
        assertEquals(false, visitor.visit(hand5));
        assertEquals(false, visitor.visit(hand6));
        assertEquals(false, visitor.visit(hand7));
    }

    @Test(expected = HandCreationException.class)
    public void test_02_cannotCreateHandWithMoreThan7Cards() throws HandCreationException {
        new HandImpl(1,2,3,4,5,6,7,8);
    }
}
