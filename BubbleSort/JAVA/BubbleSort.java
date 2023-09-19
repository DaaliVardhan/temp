import java.io.FileReader;
import java.util.Scanner;

public class BubbleSort{
  static int[] bubbleSort(int[] arr){
    int n = arr.length;
    for(int i = 0; i < n-1; i++){
      for(int j = 0; j < n-i-1; j++){
        if(arr[j] > arr[j+1]){
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
    return arr;
  }
  public static void main(String[] args){
    FileReader fr = new FileReader("../testcases.txt");
    Scanner sc = new Scanner(fr);
    while(sc.hasNextLine()){
      String[] line = sc.nextLine().split("#");
      String[] input = line[0].split(" ");
      String[] ExpectedOutput = line[1].split(" ");
      int[] arr = new int[input.length];
      for(int i = 0; i < input.length; i++){
        arr[i] = Integer.parseInt(input[i]);
      }
      int[] output = bubbleSort(arr);
      for(int i = 0; i < output.length; i++){
        assert output[i] != Integer.parseInt(ExpectedOutput[i]);
      }
    }
  }
}