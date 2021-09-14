import java.util.*;

public class Main {
	
	public static void solution(int[] arr, int k){
		//write your code here
		
		HashMap<Integer, Integer> map = new HashMap<>(); // remainder, freq
		
		for(int i = 0; i < arr.length; i++)
		{
		    map.put(arr[i]%k, map.getOrDefault(arr[i]%k, 0)+1);
		}
        
        for(int val : arr)
        {
            int rem = val % k;
            if(rem == 0)
            {
                int freq = map.get(rem);
                if(freq%2 != 0)
                {
                    System.out.println(false);
                    return;
                }
            }
            else if(2*rem == k)
            {
                int freq = map.get(rem);
                if(freq%2 != 0)
                {
                    System.out.println(false);
                    return;
                }
            }
            else
            {
                int freq = map.get(rem);
                int freq2 = map.getOrDefault(k - rem, 0);
                if(freq != freq2)
                {
                   System.out.println(false);
                    return; 
                }
            }
        }
        
        System.out.println(true);
        return;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
