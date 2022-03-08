/* 

K-partitions

1. You are given two integers n and k, where n represents number of elements and k represents 
     number of subsets.
2. You have to partition n elements in k subsets and print all such configurations. 


*/

import java.io.*;
import java.util.*;

public class Main {

    static int counter = 0;
	public static void solution(int i, int n, int k, int ssf, ArrayList<ArrayList<Integer>> ans) {
		// ssf = set so far(filled);
		
		if(i > n)
		{
		    if(ssf == k)
		    {
		        counter++;
		        System.out.print(counter + ". ");
		        for(ArrayList<Integer> set : ans)
		            System.out.print(set + " ");
		        System.out.println();
		    }
		    return;
		}
		
		for(int j = 0; j < ans.size(); j++)
		{
		    if(ans.get(j).size() > 0)
		    {
		        // if we are getting filled set trying adding the data in it.
		        ans.get(j).add(i);
		        solution(i+1, n, k, ssf, ans); // as we filling filled set only therefore, number of filled sets remain same
		        ans.get(j).remove(ans.get(j).size() - 1);
		    }
		    else
		    {
		        // if it is empty set add the element and break from here
		        ans.get(j).add(i);
		        solution(i+1, n, k, ssf+1, ans); // as we are creating a new set therefore, number of sets increased
		        ans.get(j).remove(ans.get(j).size() - 1);
		        break;
		    }
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}
