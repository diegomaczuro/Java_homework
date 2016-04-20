package calculator.datatypes.frac;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class FracValueParser implements AbstractValueParser {
    public GetFracFromString(String value){


    }
    public AbstractValue parse(String value) throws ParseValueException {
        try {
            System.out.println(Integer.parseInt(value));
            return new FracValue(Integer.parseInt(value), Integer.parseInt(value));
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }

    public String getDatatypeName() {
        return "рациональные числа(дроби)";
    }


}
