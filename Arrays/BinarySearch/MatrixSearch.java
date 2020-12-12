/*
Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it.
 Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order. 
The designed algorithm should have linear time complexity. 
*/

import java.util.Scanner;

public class MatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int arr[][] = new int[n][m];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				arr[i][j] = s.nextInt();
			}
		}
		int element = s.nextInt();
		int sol = matSearch(arr, n, m, element);
		if(sol == 1)
			System.out.println(element + " is present");
		else
			System.out.println(element + " is not present");

	}
	static int matSearch(int arr[][], int N, int M, int X)
    {
        // your code here
        int i = 0; 
        int j = M - 1;
        while(i < N && j >= 0)
        {
            if(arr[i][j] == X)
                return 1;
            else if(arr[i][j] > X)
                j--;
            else
                i++;
        }
        return 0;
    }

}

