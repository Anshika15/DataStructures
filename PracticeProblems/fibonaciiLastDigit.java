import java.util.Scanner;
public class fibonaciiLastDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		long n = s.nextInt();
		int fib[] = new int[60];
		fib[0] = 0;
		fib[1] = 1;
		for(int i = 2; i <= 59; i++)
		{
			fib[i] = (fib[i-1] + fib[i-2]) % 10;
		}

        int index = (int)(n % 60L);  
  
       // return f[index]; 
		System.out.println(fib[index]);
	}

}

