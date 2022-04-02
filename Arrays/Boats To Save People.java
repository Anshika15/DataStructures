import java.util.*;

public class Main {
    /* 
    
    Boats To Save People
    
1. You are given an array people where people[i] is the weight of the ith person.
2. You have infinite number of boats where each boat can carry a maximum weight of limit. 
3. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
4. Return the minimum number of boats to carry every given person.
    
    */

  public static int numRescueBoats(int[] people, int limit) {
      
      /* sort the array
      
        traverse the array using two pointers and manage the count 
        
    */
    
    Arrays.sort(people);
    
    int i = 0; int j = people.length-1;
    
    int count = 0;
    
    while(i <= j)
    {
        if(people[i] + people[j] <= limit)
        {
            count++;
            i++;
            j--;
        }
        else
        {
            count++;
            j--;
        }
    }
    
    return count;

  }

 
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] people = new int[n];

    for (int i = 0; i < n; i++)
      people[i] = scn.nextInt();

    int limit = scn.nextInt();
    int boats = numRescueBoats(people, limit);
    System.out.println(boats);
  }
}
