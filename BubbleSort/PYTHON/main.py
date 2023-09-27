import json
import sys
from BubbleSortTest import Tester

def main():
  with open('../include/testcases.json','r') as file:
    testcases = json.load(file)
  failed = False
  t = Tester()
  for testcase in testcases:
    input = testcase.get("input",[])
    output = testcase.get("output",[])
    res = t.test(input,output)
    testcase["result"] = res
    if res == False:
      failed = True
  
  with open('../include/output.json','w') as file:
    json.dump(testcases,file,indent=2)
  
  if(failed):
    raise Exception("Some testcases failed")


if __name__=="__main__":
  main()
