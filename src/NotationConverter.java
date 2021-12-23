

public class NotationConverter {
    private static final String errorMessage = "String must contain only valid roman numerals [I, V, X, L, C, D, M].";

    public int toArabic(String romanNotation) throws InvalidValueException {
        if (romanNotation == null || romanNotation.equals("")) throw new InvalidValueException(errorMessage);

        int result = 0;
        int cash = 0;

        int lastNum = parseChar(romanNotation.charAt(0));
        cash += lastNum;
        for (int i = 1; i < romanNotation.length(); i++) {
            int nowNum = parseChar(romanNotation.charAt(i));
            if (nowNum == lastNum) {
                cash += nowNum;
            } else if (nowNum > lastNum) {
                cash = nowNum - cash;
            } else {
                result += cash;
                cash = 0;
                cash += nowNum;
            }
            lastNum = nowNum;
        }
        result += cash;
        return result;
    }

    private int parseChar(char c) throws InvalidValueException {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        throw new InvalidValueException(errorMessage);
    }
}


class InvalidValueException extends RuntimeException {
    public InvalidValueException(String s) {
        super(s);
    }
}