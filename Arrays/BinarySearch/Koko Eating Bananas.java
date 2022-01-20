/*

Koko Eating Bananas

1. Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
2. Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
3. Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
4. Return the minimum integer k such that she can eat all the bananas within h hours.

*/

import java.util.*;
import java.io.*;

public class Main {
    public static int minEatingSpeed(int[]piles,int h) {
       /* max speed = max number of bananas in pile in whole array */
       /* take min speed = 0 and apply binary search on speed */
       
       /* find mid in this speed if possible to eat all bananas in given hour then decrease the speed and find the min speed and if not possible increase the speed and try to find the min speed to eat all bananas */
       
       
       int lo = 0;
       int hi = Integer.MIN_VALUE;
       
       for(int val : piles)
        hi = Math.max(hi, val);
        
       if(h == piles.length)
        return hi;
        
        int speed = Integer.MAX_VALUE;
        while(lo <= hi)
        {
            int sp = lo + (hi-lo)/2; // to avoid overflow
            if(isPossible(piles, sp, h) == true)
            {
                speed = sp;
                hi = sp-1;
            }
            else
            {
                lo = sp+1;
            }
        }
        
        return speed;
       
    }
    
    public static boolean isPossible(int[] piles, int speed, int h)
    {
        int time = 0;
        for(int i = 0; i < piles.length; i++)
        {
            time += (int)Math.ceil(piles[i]*1.0/speed);
        }
        return time <= h;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }
}
