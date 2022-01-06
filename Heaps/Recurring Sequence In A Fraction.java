/*

Recurring Sequence In A Fraction

1. You are given two numbers which represent the numerator and denominator of a fraction.
2. You have to convert this fraction into a decimal.
3. If the decimals are repeating recursively, then you have to put the recurring sequence inside a bracket.

*/
import java.util.*;

public class Main {

    public static String solution(int num, int den) {
        
        StringBuilder res = new StringBuilder();
        
        int rem = num%den;
        int ques = num/den;
        
        res.append(ques);
        if(rem == 0)
        {
            return res.toString();
        }
        else
        {
            res.append(".");
            HashMap<Integer, Integer> map = new HashMap<>();
            
            while(rem != 0)
            {
                if(map.containsKey(rem))
                {
                   int len = map.get(rem);
                   res.insert(len, "(");
                   res.append(")");
                   break;
                }
                else
                {
                    map.put(rem, res.length());
                    rem *= 10;
                    ques = rem/den;
                    rem = rem%den;
                    res.append(ques);
                }
            }
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int den = scn.nextInt();
		System.out.println(solution(num , den));
	}

}
