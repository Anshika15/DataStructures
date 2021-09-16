import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		// write your code here
        HashMap<Integer, Integer> prefSum = new HashMap<>();// prefix sum , frequency
        prefSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            if(prefSum.containsKey(sum))
            {
               count += prefSum.get(sum);
               prefSum.put(sum, prefSum.get(sum)+1);
            }
            else
            {
                prefSum.put(sum, 1);
            }
        }
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}

}
