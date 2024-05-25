import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class ProgramRunner extends Runner {
    private String program;

    public ProgramRunner(String program) {
        this.program = program;
    }

    public HashMap<String, String> run(String input) {
        HashMap<String, String> result = new HashMap<>();
        String outcome = "";
        RunResult runResult = runProcess(input);

        if (runResult.getReturnCode() == 0) {
            outcome = PASS;
        } else if (runResult.getReturnCode() < 0) {
            outcome = FAIL;
        } else {
            outcome = UNRESOLVED;
        }

        result.put(runResult.getResultString(), outcome);
        return result;
    }

    private RunResult runProcess(String input) {
        String log = "";
        int exitCode = 0;
        
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(program);
            processBuilder.redirectErrorStream(true); // Redirect error stream to output stream
            Process process = processBuilder.start();

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                writer.write(input);
                writer.flush();
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    log += line + "\n";
                }
            }

            exitCode = process.waitFor();
        } catch (IOException | InterruptedException e) {
            log += e.getMessage();
        }

        return new RunResult(log, exitCode);
    }
}
