/*
Pairs With Given Sum In Two Sorted Matrices

1. You are given a number N and two sorted matrices(A and B) of N*N dimensions.
2. You are also given a number X.
3. You have to find the count of all valid pairs from matrices whose sum is equal to X.
4. A pair is called valid if one element of the pair is selected from A and the second element is selected from B.

*/import java.util.*;

public class Main {
	
    public static int solve(int[][] num1, int[][] num2, int k) {
		/* make freq map from one matrix and check for target - arr[i][j] from other matrix in map to make pair */
		
		HashMap<Integer, Integer> map = new HashMap<>(); // eleemnt, freq
		
		for(int i = 0; i < num1.length; i++)
		{
		    for(int j = 0; j < num1[i].length; j++)
		    {
		        map.put(num1[i][j], map.getOrDefault(num1[i][j], 0)+1);
		    }
		}
		
		int count = 0;
		
		for(int i = 0; i < num2.length; i++)
		{
		    for(int j = 0; j < num2[i].length; j++)
		    {
		        if(map.containsKey(k - num2[i][j]))
		        {
		            count += map.get(k - num2[i][j]); // as each elemnt will make a pair therefore we are adding freq of element
		        }
		    }
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] mat1 = new int[N][N];
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}

		int[][] mat2 = new int[N][N];
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		System.out.println(solve(mat1, mat2, K));

	}

}
