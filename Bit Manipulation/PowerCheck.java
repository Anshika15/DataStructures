import java.util.Scanner;

public class PowerCheck {
	
	  // Function to check if given number is power of two
    public static boolean isPowerofTwo(long n){
        
        int c = setBits(n);
        if(c == 1)
            return true;
        return false;
        
    }
    
    static int setBits(long N){
        int count = 0;
        while(N > 0)
        {
            if((N & 1) > 0)
                count++;
            N = N >> 1;
        }
        return count;
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		System.out.println("is power of two: " + isPowerofTwo(n));

	}

}

