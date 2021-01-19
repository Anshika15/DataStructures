import java.util.*;
public class ithBitSetOrNot {
	
	static boolean checkKthBit(int n, int k){
        int i = 1;
        i = i << k;
        int res = n & i;
        if(res == 0)
            return false;
        return true;
        
    }

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		System.out.println("kth bit is set: " + checkKthBit(n, k));
		
	}

}

