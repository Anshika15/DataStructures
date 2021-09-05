import java.io.*;
import java.util.*;

public class Main {
    
   static class Pair implements Comparable<Pair>{
       int listNum;
       int listIndex;
       int val;
       
       public int compareTo(Pair p)
       {
           return this.val - p.val;
       }
       
       Pair(int listNum, int listIndex, int val)
       {
           this.listNum = listNum;
           this.listIndex = listIndex;
           this.val = val;
          
       }
       
   }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here
      
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int i = 0; i < lists.size(); i++)
      {
          pq.add(new Pair(i, 0, lists.get(i).get(0)));
      }
      
      while(pq.size() > 0)
      {
          Pair p = pq.remove();
          rv.add(p.val);
          p.listIndex++;
          
          if(p.listIndex < lists.get(p.listNum).size())
          {
              p.val = lists.get(p.listNum).get(p.listIndex);
              pq.add(p);
          }
      }
      

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
