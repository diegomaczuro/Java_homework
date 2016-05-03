package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.OperationNotSupportedException;


/**
 * Created by shido on 27.04.16.
 */
public class ComplexValue extends AbstractValue {
    private final double value1, value2;

    public ComplexValue(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String toString() {
        return Double.toString(value1)+"  +  i*"+Double.toString(value2);
    }

    public AbstractValue add(AbstractValue operand) {
        return new ComplexValue(value1+((ComplexValue) operand).value1, value2+((ComplexValue) operand).value2);
    }

    public AbstractValue sub(AbstractValue operand) {
        return new ComplexValue(value1-((ComplexValue) operand).value1, value2-((ComplexValue) operand).value2);
    }

    public AbstractValue mul(AbstractValue operand) {
        return new ComplexValue(value1 * ((ComplexValue) operand).value1 - value2 * ((ComplexValue) operand).value2,
                value1 * ((ComplexValue) operand).value2+value2*((ComplexValue) operand).value1);
    }

    public AbstractValue div(AbstractValue operand) throws OperationNotSupportedException {
        return  new ComplexValue((value1 * ((ComplexValue) operand).value1+ value2 * ((ComplexValue) operand).value2)/
                (Math.pow(((ComplexValue) operand).value1, 2.0) + Math.pow(((ComplexValue) operand).value2, 2)) ,
                (value2*((ComplexValue) operand).value1-value1*((ComplexValue) operand).value2)/
                        (Math.pow(((ComplexValue) operand).value1, 2.0) + Math.pow(((ComplexValue) operand).value2, 2)));
    }
}
