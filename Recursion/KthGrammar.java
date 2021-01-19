/*
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and 
 * replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 */

import java.util.*;
public class KthGrammar {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		System.out.println(kthGrammar(n, k));
	}
	
	static int kthGrammar(int N, int K) {
        
        if(N == 1 && K == 1)
        {
            return 0;
        }
        int mid = (int) Math.pow(2, N-1)/2;
        if(K <= mid)
            return kthGrammar(N-1, K);
        else
        {
            int res = kthGrammar(N-1, K - mid);
            if(res == 1)
                return 0;
            else
                return 1;
        }
        
    }

}

