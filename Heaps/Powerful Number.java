/*

Powerful Number

1. You are given three numbers A, B, and X.
2. You have to print all-powerful numbers that have value less than or equal to X.
3. A number is powerful if it is equal to x^i + y^j for i >= 0 and j >= 0.
*/

import java.util.*;

public class Main {
	
	public static ArrayList<Integer> powerfulIntegers(int x, int y, int bound) {
		
        /* X^i can be less than bound i.e; X^i < bound it cannot ne equal to bound as y^j will atleast contribute for 1 as min val for j can be 0 */
        /*  simlilary for y^j < bound */
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 1; i < bound; i *= x)
        {
            for(int j = 1; i+j <= bound; j *= y)
            {
                set.add(i+j);
                if(y == 1)
                    break;
            }
            if(x == 1)
                break;
        }
		return new ArrayList<>(set);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		int y = scn.nextInt();
		int bound = scn.nextInt();
		scn.close();
		ArrayList<Integer> ret = new ArrayList<>();
		ret = powerfulIntegers(x, y, bound);
		Collections.sort(ret);
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(ret.get(i) + " ");
		}
	}

}
