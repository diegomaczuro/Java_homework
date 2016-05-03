package calculator.datatypes.vector;

import calculator.AbstractValueParser;
import calculator.AbstractValue;
import calculator.ParseValueException;


/**
 * Created by shido on 27.04.16.
 */
public class VectorValueParser implements AbstractValueParser  {
    public AbstractValue parse(String value) throws ParseValueException {
        try {

            String[] word = value.split("[(,)]");
            double[] val = new double[word.length-1];
            int i;
            for (i=0; i<val.length; i++ ){
                double numb = Double.parseDouble(word[i+1]);

                val[i] = numb;

            }

            return new VectorValue(val);
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }

    public String getDatatypeName() {
        return "вектора";
    }
}
