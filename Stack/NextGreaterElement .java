class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        
        Stack<Long> stack = new Stack<>();
        
        long[] res = new long[n];
        
        for(int i = n-1; i >= 0; i--)
        {
            if(stack.size() == 0)
                res[i] = -1;
            else if(stack.size() > 0 && stack.peek() > arr[i])
                res[i] = stack.peek();
            else if(stack.size() > 0 && stack.peek() <= arr[i])
            {
                while(stack.size() > 0 && stack.peek() <= arr[i])
                    stack.pop();
                if(stack.size() == 0)
                    res[i] = -1;
                else
                    res[i] = stack.peek();
            }
            
            stack.push(arr[i]);
            
        }
        
     return res;   
    } 
}
