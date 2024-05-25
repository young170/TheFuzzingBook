import java.util.HashMap;

public class PrintRunner extends Runner {
    public HashMap<String, String> run(String input) {
        HashMap<String, String> runResult = new HashMap<>();
        runResult.put(input, Runner.UNRESOLVED);

        System.out.println(input);

        return runResult;
    }
}
