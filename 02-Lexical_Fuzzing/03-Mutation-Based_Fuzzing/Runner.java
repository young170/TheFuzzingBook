import java.util.ArrayList;

public class Runner {
    
    public static void main(String[] args) {
        ArrayList<String> seeds = new ArrayList<>();
        seeds.add("hello");
        seeds.add("world");

        MutationFuzzer fuzzer = new MutationFuzzer(seeds, 1, 5);
        fuzzer.reset();

        for (int i = 0; i < 10; i++) {
            String fuzzedInput = fuzzer.fuzz();
            System.out.println(fuzzedInput);
        }
    }

}
