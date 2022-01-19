/*
Maximum Frequency Stack

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

*/
class FreqStack {

    /* create two hashmaps
        one with freq, stack
        second with val, freq */
    
    HashMap<Integer, Stack<Integer>> freqSt;
    HashMap<Integer, Integer> freqMap;
    int maxFreq;
    
    public FreqStack() {
        freqSt = new HashMap<>();
        freqMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int currFreq = freqMap.getOrDefault(val,0);
        currFreq++;
        freqMap.put(val, currFreq);
        
        if(!freqSt.containsKey(currFreq))
        {
           freqSt.put(currFreq, new Stack<>()); 
        }
        freqSt.get(currFreq).push(val);
        maxFreq = Math.max(maxFreq, currFreq);
    }
    
    public int pop() {
        
        int ans = freqSt.get(maxFreq).pop();
        
        int currFreq = freqMap.get(ans);
        currFreq--;
        freqMap.put(ans, currFreq);
        if(freqSt.get(maxFreq).size() == 0)
            maxFreq--;
        
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
