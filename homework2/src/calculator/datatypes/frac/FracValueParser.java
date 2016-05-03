package calculator.datatypes.frac;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.DivisionByZeroException;
import calculator.ParseValueException;

public class FracValueParser implements AbstractValueParser {

    public AbstractValue parse(String value) throws ParseValueException {
        try {
            String[] word = value.split("[%]");

            int multiplyer = Integer.parseInt(word[0]);
            int denominator = Integer.parseInt(word[1]);

            if (denominator == 0) {
                throw new NumberFormatException();
            }

            return new FracValue(multiplyer, denominator);
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }

    }

    public String getDatatypeName() {
        return "рациональные числа(дроби)";
    }


}
