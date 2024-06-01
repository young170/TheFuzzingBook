import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class MutationFuzzer extends Fuzzer {

    private static final Random random = new Random();
    private int seedIdx;
    private List<String> seed;
    private List<String> population;
    private int minMutations;
    private int maxMutations;
    private String inp;

    public MutationFuzzer(ArrayList<String> seed, int minMutations, int maxMutations) {
        this.seed = seed;
        this.minMutations = minMutations;
        this.maxMutations = maxMutations;
    }

    public void reset() {
        population = new ArrayList<>(seed);
        seedIdx = 0;
    }

    public String mutate(String seed) {
        List<Function<String, String>> mutators = new ArrayList<>();
        mutators.add(MutationFuzzer::deleteRandomCharacter);
        mutators.add(MutationFuzzer::insertRandomCharacter);
        mutators.add(MutationFuzzer::flipRandomCharacter);

        Function<String, String> mutator = mutators.get(random.nextInt(mutators.size()));
        return mutator.apply(seed);
    }

    public static String deleteRandomCharacter(String s) {
        if (s.isEmpty()) {
            return s;
        }

        int pos = random.nextInt(s.length());
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    public static String insertRandomCharacter(String s) {
        int pos = random.nextInt(s.length() + 1);
        char randomChar = (char) random.ints(32, 127).findFirst().getAsInt();
        return s.substring(0, pos) + randomChar + s.substring(pos);
    }

    public static String flipRandomCharacter(String s) {
        if (s.isEmpty()) {
            return s;
        }

        int pos = random.nextInt(s.length());
        char c = s.charAt(pos);
        int bit = 1 << random.nextInt(6);
        char newC = (char) (c ^ bit);
        return s.substring(0, pos) + newC + s.substring(pos + 1);
    }

    public String createCandidate() {
        String candidate = population.get(random.nextInt(population.size()));
        int trials = random.nextInt(maxMutations - minMutations + 1) + minMutations;
        for (int i = 0; i < trials; i++) {
            candidate = mutate(candidate);
        }
        return candidate;
    }

    public String fuzz() {
        if (seedIdx < seed.size()) {
            // Still seeding
            inp = seed.get(seedIdx);
            seedIdx++;
        } else {
            // Mutating
            inp = createCandidate();
        }
        return inp;
    }

}
