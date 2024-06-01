public class Runner {
    
    public static void main(String[] args) {
        MutationFuzzer fuzzer = new MutationFuzzer();
        String seed = fuzzer.fuzzer();
        String mutatedSeed = fuzzer.mutate(seed);

        System.out.println(seed);
        System.out.println(mutatedSeed);
    }

}
