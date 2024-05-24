import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Fuzzer {

    public static void main (String[] args) {
        Fuzzer fuzzer = new Fuzzer();
        String data = fuzzer.fuzzer();

        Path filePath = Paths.get("input/input.txt");

        try {
            Files.write(filePath, data.getBytes());

            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Overload of fuzzer(int, int, int)
     * Default parameters
     * 
     * @return fuzzer(int, int, int)
     */
    public String fuzzer () {
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
    public String fuzzer (int maxLength, int charStart, int charRange) {
        Random random = new Random();
        int stringLength = random.ints(0, maxLength + 1).findFirst().getAsInt();
        String out = "";

        for (int i = 0; i < stringLength; i++) {
            out += (char) (random.ints(charStart, charStart + charRange).findFirst().getAsInt());
        }

        return out;
    }

};
