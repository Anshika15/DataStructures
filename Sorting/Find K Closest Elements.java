import java.util.*;
import java.io.*;

public class Main {
    
    static class Pair implements Comparable<Pair>{
        int val;
        int gap;
        Pair(){}
        
        Pair(int val, int gap)
        {
            this.val = val;
            this.gap = gap;
        }
        
        public int compareTo(Pair p){
            if(this.gap == p.gap)
                return this.val - p.val;
            else
                return this.gap - p.gap;
        }
    }

    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    /* using priority Queue time complexity-> O(nlogk) 
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        //  O(nlogk) 
        for(int i = 0; i < arr.length; i++)
        {
            if(pq.size() < k)
            {
                pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
            }
            else
            {
                if(pq.peek().gap > Math.abs(x - arr[i]))
                {
                    pq.remove();
                    pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
                }
            }
        }
        
        while(pq.size() > 0)
        {
            res.add(pq.remove().val);
        }
        //  O(klogk) 
        Collections.sort(res);
        return res;
    }
    */
    
    /* optimised approach using binary search*/
    /* o(logn) + O(klogk) */
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        int lo = 0;
        int hi = arr.length-1;
        int mid = 0;
        /* O(logn) */
        while(lo <= hi)
        {
            mid = lo + (hi - lo)/2;
            
            if(arr[mid] == x)
                break;
            else if(arr[mid] > x)
                hi = mid-1;
            else lo = mid+1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        lo = mid-1;
        hi = mid;
        while(lo >= 0 && hi < arr.length && k > 0)
        {
            if(Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x))
            {
                list.add(arr[lo]);
                lo--;
            }
            else
            {
               list.add(arr[hi]);
               hi++; 
            }
            k--;
        }
        
        while(k > 0 && lo >= 0)
        {
            list.add(arr[lo]);
            lo--;
            k--;
        }
        while(k > 0 && hi < arr.length)
        {
            list.add(arr[hi]);
            k--;
            hi++;
        }
        /* O(klogk) */
        Collections.sort(list);
        return list;
    }
    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}
