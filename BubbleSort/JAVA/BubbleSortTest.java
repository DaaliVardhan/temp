

public class BubbleSortTest {
  
  boolean test(int[] input,int[] expected_output){
    BubbleSort bs = new BubbleSort();
    int[] output = bs.bubbleSort(input);
    if(output.length != input.length) return false;
    for(int i=0;i<output.length;i++){
      if(output[i]!=expected_output[i])
        return false;
    }
    System.out.println();
    return true;
  }
}
