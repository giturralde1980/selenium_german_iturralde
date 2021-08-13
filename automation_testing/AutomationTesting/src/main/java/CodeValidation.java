import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class CodeValidation {


    public static void main(String args[])
    {
        for (int i=0; i <=10; i++)
        {
        System.out.println(generateStammnummer());
        }
    }

    public static String generateStammnummer() {
        String nummer = RandomStringUtils.random(8, "0123456789");
        return nummer + calcCheckDigit(nummer);
    }

    private static int calcCheckDigit(String stamm) {
        String factor = "234567";
        int checksum = 0;
        int p = 0;

        stamm = StringUtils.reverse(stamm);
        for (int i = 0; i < stamm.length(); i++) {
            char c = stamm.toCharArray()[i];
            checksum += Character.getNumericValue(c) * Character.getNumericValue(factor.charAt(p));
            p = ++p % factor.length();
        }

        int checkDigit = checksum % 11;
        if (checkDigit > 9) {
            checkDigit = 0;
        }

        return checkDigit;
    }

}
