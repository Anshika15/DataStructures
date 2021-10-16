import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
            set.add(arr[i]);
        }
		
		int res = 0;
		int i = -1;
		int j = -1;
		HashMap<Integer, Integer> map = new HashMap<>(); // freq map
		while(true)
		{
		    boolean flag1 = false;
		    boolean flag2 = false;
		    
		    while(i < n-1)
		    {
		        flag1 = true;
		        i++;
		        map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
		        if(map.size() == set.size())
		        {
		            res += n-i;
		            break; 
		        }
		           
		    }
		    
		    while(j < i)
		    {
		        flag2 = true;
		        j++;
		        if(map.get(arr[j]) == 1)
		            map.remove(arr[j]);
		        else 
		            map.put(arr[j], map.get(arr[j])-1);
		            
		        if(map.size() == set.size())
		        {
		            res += n-i;
		        }
		        else
		        {
		            break;
		        }
		           
		    }
		    
		    if(flag1 == false && flag2 == false)
		    {
		        break;
		    }
		}
		
		System.out.println(res);
		
	}


}
