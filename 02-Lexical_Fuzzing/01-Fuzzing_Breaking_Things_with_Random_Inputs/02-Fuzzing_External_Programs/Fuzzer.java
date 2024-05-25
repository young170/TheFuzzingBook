import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;

public class Fuzzer {

    public static void main(String[] args) {
        Fuzzer fuzzer = new Fuzzer();
        int trials = 100;
        String targetProgramName = "bc";
        String inputFilePath = "input/input.txt";
        HashMap<String, String> runs = new HashMap<>();

        for (int i = 0; i < trials; i++) {
            String data = fuzzer.fuzzer();
            Path filePath = Paths.get(inputFilePath);
            fuzzer.writeDataToFile(filePath, data);

            String result = fuzzer.runExternalProgram(targetProgramName, inputFilePath);

            runs.put(data, result);

            System.out.println(result);
        }
    }

    public void writeDataToFile(Path filePath, String data) {
        try {
            Files.write(filePath, data.getBytes());

            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String runExternalProgram(String programName, String inputFileName) {
        String runResult = "";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(programName, inputFileName);
            processBuilder.redirectErrorStream(true); // Redirect error stream to output stream
            Process process = processBuilder.start();

            // Read the output from the program
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    runResult += line;
                }
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Process exited with code: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            // e.printStackTrace();
            runResult += e.getMessage();
        }

        return runResult;
    }

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
        int stringLength = random.ints(0, maxLength + 1).findFirst().getAsInt();
        String out = "";

        for (int i = 0; i < stringLength; i++) {
            out += (char) (random.ints(charStart, charStart + charRange).findFirst().getAsInt());
        }

        return out;
    }

};
