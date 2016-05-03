package calculator.datatypes.complex;

import calculator.AbstractValueParser;
import calculator.AbstractValue;
import calculator.ParseValueException;


/**
 * Created by shido on 27.04.16.
 */
public class ComplexValueParser implements AbstractValueParser {
    public AbstractValue parse(String value) throws ParseValueException {
        try {

            String[] word = value.split("[i+-]");



            return new ComplexValue(Double.parseDouble(word[0]), Double.parseDouble(word[1]));
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }

    public String getDatatypeName() {
        return "комплексные числа";
    }
}
