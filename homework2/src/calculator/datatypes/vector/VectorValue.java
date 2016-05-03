package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;


/**
 * Created by shido on 27.04.16.
 */
public class VectorValue extends AbstractValue {
    private final double[] value;

    public VectorValue(double[] value) {
        this.value = value;

    }

    public String toString() {
        String s = "(";
        int i;
        for (i=0; i<value.length-1; i++ ){
            s = s + Double.toString(value[i])+",";

        }
        s = s + Double.toString(value[i])+")";

        return s;
    }

    public AbstractValue add(AbstractValue operand) {
        double[] result = new double[value.length];
        int i;
        for (i=0; i<value.length; i++ ){
            result[i] = value[i] + ((VectorValue) operand).value[i];

        }
        return new VectorValue(result);
    }

    public AbstractValue sub(AbstractValue operand) {
        double[] result = new double[value.length];
        int i;
        for (i=0; i<value.length; i++ ){
            result[i] = value[i] - ((VectorValue) operand).value[i];

        }
        return new VectorValue(result);

    }

    public AbstractValue mul(AbstractValue operand) throws OperationNotSupportedException {
        int n = 0;
        if (value.length > ((VectorValue) operand).value.length){n = value.length;}
        else {n = ((VectorValue) operand).value.length;}
        double[] result = new double [n];
        double m = 0;
        int i;

        for (i=0; i<n; i++ ) {
            if (value.length == 1) {
                result[i] =  ((VectorValue) operand).value[i]*value[0];
            }
            else if (((VectorValue) operand).value.length == 1) {
                result[i] =  ((VectorValue) operand).value[0]*value[i];
            }
            else{
                throw new OperationNotSupportedException("умножения вектора на вектор");
            }
        }

        return new VectorValue(result);
    }

    @Override
    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException, OperationNotSupportedException {
        throw new OperationNotSupportedException("/");
    }

}
