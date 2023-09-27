#include "include/BubbleSort.hpp"
#include "include/BubbleSortTest.hpp"
#include<iostream>



bool BubbleSortTest::test(std::vector<int>& input, std::vector<int>& output){
    BubbleSort bubbleSort;
    std::vector<int> res = bubbleSort.bubbleSort(input);
    if(res.size()!=output.size()){
      return false;
    }
    for(int i=0;i<res.size();i++){
      if(res[i]!=output[i]){
        return false;
      }
    }
    return true;
}