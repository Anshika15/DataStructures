import java.io.*;
import java.util.*;

public class Main {

/*
1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
*/
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    int setmask = (1 << i); // 0001000
    int unsetmask = ~(1 << j); // 1110111
    int togglemask = (1 << k); // 0001000
    int checkmask = (1 << m); // 0001000
    
    System.out.println(n | setmask); // to on a bit use or
    System.out.println(n & unsetmask); // to off a bit use and
    System.out.println(n ^ togglemask); // to togle a bit use xor
    System.out.println((n & checkmask) == 0 ? false : true); 
  }

}
