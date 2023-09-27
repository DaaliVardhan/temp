from typing import List

class Solution:
    def bubbleSort(self,arr : List[int]):
        for i in range(len(arr)):
            for j in range(len(arr)-1-i):
                if(arr[j]>arr[j+1]):
                    arr[j],arr[j+1] = arr[j+1],arr[j]
        return arr