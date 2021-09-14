import java.util.*;

public class Main {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		//write your code here
        ArrayList<Integer> res = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < k-1; i++)
        {
           map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); 
        }
    
        int j = 0;
        for(int i = k-1; i < arr.length; i++)
        {
           map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);// acquire
           
           res.add(map.size());
           
           int freq = map.get(arr[j]);
           if(freq == 1)
            map.remove(arr[j]);
           else
            map.put(arr[j], freq - 1);
           j++;
        }
        
        
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}
