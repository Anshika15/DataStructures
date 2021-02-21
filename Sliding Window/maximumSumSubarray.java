class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> Arr,int N){
        // code here
        
        int i = 0, j = 0;
        int sum = 0;
        int maxele = Integer.MIN_VALUE;
        while(j < N)
        {
            sum += Arr.get(j);
            if(j - i + 1 < k)
                j++;
            else if(j - i + 1 == k)
            {
                maxele = Math.max(maxele, sum);
                sum -= Arr.get(i);
                i++;
                j++;
            }
        }
       return maxele; 
    }
}
