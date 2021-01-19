import java.util.Scanner;

public class CountSetBits {
	
	static int setBits(int N){
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
		int n = s.nextInt();
		
		System.out.println(setBits(n));

	}

}

