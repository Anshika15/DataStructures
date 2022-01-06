/*

Car Pooling

1. A car moving in east direction has to make some pickups/drops(passengers) on the way.
2. Car has a limited capacity to carry passengers.
3. Given a List of Trips i.e. trip[i] = [pickup_location,drop_Location,num_passengers] , find out whether it is possible to make all trips on the way or not.
NOTE: Car will only move in east directions i.e. no turn-around trip is possible.
*/

import java.util.Scanner;

public class Main {
  public static boolean carPooling(int trips[][], int cap) {
    
    /* find last drop location and create a array till that point */
    
    /* at pickup location store the count of paasengers and at drop store the -ve of passengers as they will be dropped at that location
    /* now at each location we will store how many passengers will be there by doing the sum of current passenger count and prev passenger count in array */
    /* if at any point we get passenger count > capacity of passengers we can not pool the car */
    
    int lastDropLocation = -1;
    for(int trip[] : trips)
    {
        lastDropLocation = Math.max(lastDropLocation, trip[1]);
    }
    
    int passCountArr[] = new int[lastDropLocation+1];
    
    for(int i = 0; i < trips.length; i++)
    {
        passCountArr[trips[i][0]] += trips[i][2];
        passCountArr[trips[i][1]] -= trips[i][2];
    }
    
    for(int i = 1; i <= lastDropLocation; i++)
    {
        passCountArr[i] += passCountArr[i-1];
        if(passCountArr[i] > cap)
            return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int trips[][] = new int[n][3];
    for (int i = 0 ; i < n ; i++) {
      trips[i][0] = scn.nextInt();
      trips[i][1] = scn.nextInt();
      trips[i][2] = scn.nextInt();
    }
    int cap = scn.nextInt();

    if (carPooling(trips, cap)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

  }
}
