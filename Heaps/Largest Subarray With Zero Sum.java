import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		// write your code here
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>(); // prefixsum, index
        prefixSum.put(0, -1);
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            
            if(!prefixSum.containsKey(sum))
            {
                prefixSum.put(sum, i);
            }
            else
            {
                int len = i - prefixSum.get(sum);
                max = Math.max(max, len);
            }
        }
		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
