import java.util.Random;

public class Fuzzer {

    /**
     * Overload of fuzzer(int, int, int)
     * Default parameters
     * 
     * @return fuzzer(int, int, int)
     */
    public String fuzzer() {
        return fuzzer(100, 32, 32);
    }

    /**
     * Creates a random string up to 'maxLength' characters
     * Range of characters (charStart, charStart + charRange)
     * 
     * @param maxLength Maximum length of random string
     * @param charStart starting value of the length of the random string
     * @param charRange range/length of the random string
     * @return random string
     */
    public String fuzzer(int maxLength, int charStart, int charRange) {
        Random random = new Random();
        int stringLength = random.nextInt(maxLength + 1);
        String out = "";

        for (int i = 0; i < stringLength; i++) {
            out += (char) (random.ints(charStart, charStart + charRange).findFirst().getAsInt());
        }

        return out;
    }

};
