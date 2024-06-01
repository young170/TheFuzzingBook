import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class MutationFuzzer extends Fuzzer {

    private static final Random random = new Random();

    public String mutate(String seed) {
        List<Function<String, String>> mutators = new ArrayList<>();
        mutators.add(MutationFuzzer::deleteRandomCharacter);
        mutators.add(MutationFuzzer::insertRandomCharacter);
        mutators.add(MutationFuzzer::flipRandomCharacter);
        
        Function<String, String> mutator = mutators.get(random.nextInt(mutators.size()));
        return mutator.apply(seed);
    }
    
    /**
     * 
     * @param s
     * @returns 's' with a random character deleted
     */
    public static String deleteRandomCharacter(String s) {
        if (s.isEmpty()) {
            return s;
        }

        int pos = random.nextInt(s.length());

        return s.substring(0, pos) + s.substring(pos + 1, s.length());
    }

    /**
     * 
     * @param s
     * @return 's' with a random character inserted
     */
    public static String insertRandomCharacter(String s) {
        int pos = random.nextInt(s.length());
        char randomChar = (char) random.ints(32, 127).findFirst().getAsInt();

        return s.substring(0, pos) + randomChar + s.substring(pos, s.length());
    }

    public static String flipRandomCharacter(String s) {
        if (s.isEmpty()) {
            return s;
        }

        int pos = random.nextInt(s.length());
        char c = s.charAt(pos);
        int bit = 1 << random.nextInt(6);
        char newC = (char) ((char) c ^ bit);

        // flip not insert
        return s.substring(0, pos) + newC + s.substring(pos + 1, s.length());
    }

}
