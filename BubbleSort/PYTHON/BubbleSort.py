from typing import List
import os

def bubbleSort(arr: List[int])->List[int]:
    n = len(arr)
    for i in range(n):
        for j in range(0, n-i-1):
            if(arr[j] > arr[j+1]):
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr


if __name__ == "__main__":
    path = os.path.join(os.path.dirname(__file__),"../testcases.txt")
    with open(path, "r") as f:
        for line in f:
            testcase = line.split("#")
            input = list(map(int, testcase[0].split(" ")))
            output = list(map(int, testcase[1].split(" ")))
            assert bubbleSort(input) == output