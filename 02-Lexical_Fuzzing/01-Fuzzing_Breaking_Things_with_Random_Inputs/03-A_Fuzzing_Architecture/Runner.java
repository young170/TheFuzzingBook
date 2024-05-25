import java.util.HashMap;

public class Runner {
    public static String PASS = "PASS";
    public static String FAIL = "FAIL";
    public static String UNRESOLVED = "UNRESOLVED";   
    
    public HashMap<String, String> run(String input) {
        HashMap<String, String> runResult = new HashMap<>();
        runResult.put(input, Runner.UNRESOLVED);
        return runResult;
    }
}
