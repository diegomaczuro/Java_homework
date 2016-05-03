package calculator.datatypes.frac;

import calculator.AbstractValue;
import calculator.OperationNotSupportedException;

import java.math.*;


public class FracValue extends AbstractValue{
    private final int value1, value2;

    public FracValue(int value1, int value2) {
        super();
        this.value1 = value1;
        this.value2 = value2;

    }

    public String toString() {return Integer.toString(value1)+'/'+Integer.toString(value2);}

    public FracValue add(AbstractValue operand) {
        int multiplyer  =  value1*((FracValue) operand).value2 + ((FracValue) operand).value1*value2;
        int denominator =  value2*((FracValue) operand).value2;
        BigInteger bi1 = new BigInteger(Integer.toString(multiplyer));
        BigInteger bi2 = new BigInteger(Integer.toString(denominator));
        BigInteger bi3 = bi1.gcd(bi2);
        int m = bi3.intValue();
        return new FracValue(multiplyer/m, denominator/m);
    }

    public AbstractValue sub(AbstractValue operand) {
        int multiplyer  = value1*((FracValue) operand).value2 - ((FracValue) operand).value1*value2;
        int denominator = value2*((FracValue) operand).value2;
        BigInteger bi1 = new BigInteger(Integer.toString(multiplyer));
        BigInteger bi2 = new BigInteger(Integer.toString(denominator));
        BigInteger bi3 = bi1.gcd(bi2);
        int m = bi3.intValue();
        return new FracValue(multiplyer/m, denominator/m);
    }

    public AbstractValue mul(AbstractValue operand) {
        int multiplyer  = value1 * ((FracValue) operand).value1;
        int denominator = value2 * ((FracValue) operand).value2;
        BigInteger bi1 = new BigInteger(Integer.toString(multiplyer));
        BigInteger bi2 = new BigInteger(Integer.toString(denominator));
        BigInteger bi3 = bi1.gcd(bi2);
        int m = bi3.intValue();
        return new FracValue(multiplyer/m, denominator/m);
    }

    public AbstractValue div(AbstractValue operand) throws OperationNotSupportedException {
        int multiplyer  = value1 * ((FracValue) operand).value2;
        int denominator = value2*((FracValue) operand).value1;
        BigInteger bi1 = new BigInteger(Integer.toString(multiplyer));
        BigInteger bi2 = new BigInteger(Integer.toString(denominator));
        BigInteger bi3 = bi1.gcd(bi2);
        int m = bi3.intValue();
        return new FracValue(multiplyer/m, denominator/m);
    }

}

