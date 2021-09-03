import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	public static void getMaxGold(int[][] arr){
		//write your code here
		boolean vis[][] = new boolean[arr.length][arr[0].length];
		
		for(int i = 0; i < arr.length; i++)
		{
		    for(int j = 0; j < arr[i].length; j++)
		    {
		        if(arr[i][j] != 0 && !vis[i][j])
		        {
		            ArrayList<Integer> bag = new ArrayList<>(); 
		            travelAndCollectGold(i, j, vis, bag, arr);
		            int sum = 0;
		            for(int val : bag)
		            {
		                sum += val;
		            }
		            
		            if(sum > max)
		                max = sum;
		        }
		    }
		}
		
	}
	
	public static void travelAndCollectGold(int row, int col, boolean[][] vis, ArrayList<Integer> bag, int[][] arr)
	{
	    if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || vis[row][col] || arr[row][col] == 0)
	    return;
	    
	    bag.add(arr[row][col]);
	    vis[row][col] = true;
        travelAndCollectGold(row+1, col, vis, bag, arr);	    
        travelAndCollectGold(row, col+1, vis, bag, arr);	    
        travelAndCollectGold(row-1, col, vis, bag, arr);
        travelAndCollectGold(row, col-1, vis, bag, arr);
	    
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}
