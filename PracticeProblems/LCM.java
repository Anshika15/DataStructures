import java.util.*;
public class LCM {
	long gcd(long a, long b)
	{
		if(b == 0)
		{
			return a;
		}
		return gcd(b, a%b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		long a = s.nextInt();
		long b = s.nextInt();
		LCM obj = new LCM();
		long g = obj.gcd(a, b);
		long lcm = (a * b) / g;
		System.out.println(lcm);

	}

}

