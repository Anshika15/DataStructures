import java.util.*;

public class Main {
    
    /*
    Sieve Of Eratosthenes
    
    1. Given an Integer 'n'.
    2. Print all primes from 2 to 'n'.
    3. Portal is not forced you, but try to submit the problem in less than n.root(n) complexity.
    */
    
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        if(n == 0 || n == 1)
            return;
       /* Algorithm */
       
       /* steps ->
       
        1) create a boolean of size = n+1 
        2) initilaize 0, 1 with false and rest of the elements with true
        3) Start iteration from 2
           -> i = 2 (it is marked as true => it is prime so unmark all its factors as false)
           -> i = 3 (it is marked as true => it is prime so unmark all its factors as false)
           -> i = 4(it is marked as false => all its factors are also set  to false so no need to iterate over it)
       */
       
       boolean res[] = new boolean[n+1];
       Arrays.fill(res, true);
       res[0] = false;
       res[1] = false;
       
       /* Overall Time complexity -> O(n log(log(n)) */
       for(int i = 2; i*i <= n; i++) /* O(log(log(n))) */
       {
           if(res[i] == true){
            /* make factors of i false */
            for(int j = i+i; j <= n; j+= i)  /* O(n) */
            {
                res[j] = false; // not prime
            }
           }
       }
       
       for(int i = 2; i <= n; i++)
       {
           if(res[i] == true)
            System.out.print(i + " ");
       }
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}
