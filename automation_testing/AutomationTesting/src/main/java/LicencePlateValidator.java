import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LicencePlateValidator
{
    private static final int THRESHOLD = 7;
    private static final int MODULO = 11;

    public static void main(String args[])
    {
        System.out.println(isValid("559424365"));
    }

    public static boolean isValid(String value) {
        if (value == null) {
            return true;
        }
        if (!StringUtils.isNumeric(value)) {
            return false;
        }
        var checkDigit = Character.getNumericValue(value.charAt(value.length() - 1));
        var digits = digits(StringUtils.chop(value));
        var checksum = sumWithWeights(digits);
        return checkDigit == validCheckDigit(checksum);
    }
    private static int sumWithWeights(final List<Integer> digits) {
        var sum = 0;
        var multiplier = 1;
        for (int index = digits.size() - 1; index >= 0; index--) {
            multiplier++;
            if (multiplier > THRESHOLD) {
                multiplier = 2;
            }
            sum += digits.get(index) * multiplier;
        }
        return sum;
    }
    private static int validCheckDigit(int checksum) {
        int checkDigit = checksum % MODULO;
        if (checkDigit > 9) {
            checkDigit = 0;
        }
        return checkDigit;
    }
    private static List<Integer> digits(final String value) {
        var digits = new ArrayList<Integer>(value.length());
        char[] chars = value.toCharArray();
        for (char c : chars) {
            digits.add(Character.getNumericValue(c));
        }
        return digits;
    }
}
