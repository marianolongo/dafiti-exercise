package visitor;

import hand.Hand;

public interface HandVisitor<T> {

    T visit(Hand hand);
}
