import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n) {
		//write your code here
		
		if(n == 1)
		    return 0;
		int ans = 0;
		for(int i = 2; i*i <= n; i++)
		{
		    while(n%i == 0)
		    {
		        ans += i;
		        n /= i;
		    }
		}
		if(n != 1)
		    ans += n;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}
