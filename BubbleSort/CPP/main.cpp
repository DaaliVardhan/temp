#include "../include/json.hpp"
#include "include/BubbleSortTest.hpp"
#include<fstream>
#include<iostream>
#include<vector>
using json = nlohmann::json;

class TestCase{
  public:
    std::vector<int> input;
    std::vector<int> output;
    bool result;

    void to_json(json& j) {
        j = json{{"input", input}, {"output", output}, {"result", result}};
    }

    std::string toString(){
      std::string res = "";
      for(int i=0;i<input.size();i++){
        res += std::to_string(input[i]);
        if(i!=input.size()-1){
          res += " ";
        }
      }
      res += "\n";
      for(int i=0;i<output.size();i++){
        res += std::to_string(output[i]);
        if(i!=output.size()-1){
          res += " ";
        }
      }
      return res;
    }
};


json serialize(std::vector<TestCase> testcases){
  json outputJson = json::array();
  for(int i=0;i<testcases.size();i++){
    json j;
    testcases[i].to_json(j);
    outputJson.push_back(j);
    
  }
  return outputJson;
}





int main(){

  std::ifstream myfile;
  myfile.open("../include/testcases.json");
  json j;
  myfile>>j;
  std::vector<TestCase> testcases;
  for(int i=0;i<j.size();i++){
    TestCase testcase;
    testcase.input = j[i]["input"].get<std::vector<int>>();
    testcase.output = j[i]["output"].get<std::vector<int>>();
    testcases.push_back(testcase);
    
  }
  myfile.close();
  bool failed=false;
  BubbleSortTest bubbleSortTest;
  for(int i=0;i<testcases.size();i++){
    bool res =  bubbleSortTest.test(testcases[i].input, testcases[i].output);
    testcases[i].result = res;
    if(!res) failed = true;
  }
    std::ofstream outputFile("../include/output.json");
    json outputJson = serialize(testcases);
    if (outputFile.is_open()) {
        outputFile << std::setw(4) << outputJson; 
        outputFile.close();
        std::cout << "Data written to output.json." << std::endl;
    } else {
        std::cerr << "Failed to open output.json for writing." << std::endl;
    }
    if(failed)
      throw std::runtime_error("Test failed");
    return 0;
}


