import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.FileWriter;

class TestCase{
    private int[] input;
    private int[] output;
    private boolean result;
    TestCase(){};
    TestCase(int[] input,int[] output){
        this.input = input;
        this.output = output;
    }
    public boolean getResult(){
        return this.result;
    }
    public void setResult(boolean result){
        this.result = result;
    }
    public int[] getInput(){
        return this.input;
    }
    public int[] getOutput(){
        return this.output;
    }
    public void setInput(int[] input){
        this.input = input;
    }
    public void setOutput(int[] output){
        this.output =output;
    }
    public String toString(){
        return "Input: "+this.input.toString()+"\nOutput: "+this.output.toString()+"\n";
    }
}


public class Main {
    public static void main(String[] args) throws Exception
    {
        Gson gson = new Gson();
        FileReader fr = new FileReader("../include/testcases.json");
        JsonReader js = new JsonReader(fr);
        TestCase[] testcases = gson.fromJson(js,TestCase[].class);
        fr.close();
        boolean failed = false;
        for (TestCase testcase:testcases){
            int[] input = testcase.getInput();
            int[] output = testcase.getOutput();
            BubbleSortTest bst = new BubbleSortTest();
            boolean result = bst.test(input,output);
            if(result) failed=true;
            testcase.setResult(result);
        }
        try (FileWriter writer = new FileWriter("../include/output.json")) {
            gson.toJson(testcases, writer);
            System.out.println("Successfully Copied JSON Object to File...");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(failed) System.exit(1);
            else System.exit(0);
        }
    }
}

