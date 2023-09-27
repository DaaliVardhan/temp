from BubbleSort import Solution


class Tester:
  def __init__(self):
    self.s = Solution()
  
  
  def test(self,input,expected_output):
    output = self.s.bubbleSort(input)
    return output == expected_output
