package calculator.datatypes.frac;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;


public class FracValue extends AbstractValue{
    private final int value1, value2;

    public FracValue(int value1, int value2) {
        super();
        this.value1 = value1;
        this.value2 = value2;
    }

    public String toString() {
        return Integer.toString(value1)+'/'+Integer.toString(value2);
    }

    public AbstractValue add(AbstractValue operand) {
        return new FracValue(value1*((FracValue) operand).value2 + ((FracValue) operand).value1*value2, value2*((FracValue) operand).value2);
    }

    public AbstractValue sub(AbstractValue operand) {
        return new FracValue(value1*((FracValue) operand).value2 - ((FracValue) operand).value1*value2, value2*((FracValue) operand).value2);
    }

    public AbstractValue mul(AbstractValue operand) {
        return new FracValue(value1 * ((FracValue) operand).value1, value2 * ((FracValue) operand).value2);
    }

    public AbstractValue div(AbstractValue operand)
            throws DivisionByZeroException {
        int fracValue = ((FracValue) operand).value2;
        if (fracValue == 0)
            throw new DivisionByZeroException();
        return new FracValue(value1*fracValue, value2*((FracValue) operand).value1);
    }

}

