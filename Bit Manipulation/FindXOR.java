/*

Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri], for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ). Return an array containing the result for the given queries.

*/


class FindXOR {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int res[] = new int[queries.length];
        
        int pre[] = new int[arr.length];
        pre[0] = arr[0];
		for(int i = 1; i < arr.length; i++)
		{
			pre[i] = arr[i] ^ pre[i-1];
		}
		
        
        for(int i = 0; i < queries.length; i++)
        {
           int l = queries[i][0];
           int r = queries[i][1];
           if(l == 0)
			    res[i] =  pre[r];
		   else
               res[i] = pre[r]^pre[l-1];
        }
		return res;
        
    }
}
