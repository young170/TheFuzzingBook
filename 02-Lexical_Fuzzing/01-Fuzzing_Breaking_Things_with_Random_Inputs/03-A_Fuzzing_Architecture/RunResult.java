public class RunResult {
    private String resultString;
    private int returnCode;

    public RunResult(String resultString, int returnCode) {
        this.resultString = resultString;
        this.returnCode = returnCode;
    }

    public String getResultString() {
        return resultString;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setResultString(String resulString) {
        this.resultString = resulString;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
}
