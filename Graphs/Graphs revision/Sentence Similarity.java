import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] sentence1 = br.readLine().split(" ");
    String[] sentence2 = br.readLine().split(" ");

    int m = Integer.parseInt(br.readLine());

    String[][] pairs = new String[m][2];
    for (int i = 0; i < m; i++) {
      pairs[i] = br.readLine().split(" ");
    }

    System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

  }

    static HashMap<String, String> parent;
    static HashMap<String, Integer> rank; 

  public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
    
    parent = new HashMap<>();
    rank = new HashMap<>();
    
    if(Sentence1.length != Sentence2.length)
        return false;
        
    for(String[] p : pairs)
    {
        union(p[0], p[1]);
    }
    
    for(int i = 0; i < Sentence1.length; i++)
    {
        String s1 = Sentence1[i];
        String s2 = Sentence2[i];
        if(!s1.equals(s2) && !find(s1).equals(find(s2)) )
        {
           return false; 
        }
    }
    return true;
  }
  
  public static void union(String x, String y){
      String lx = find(x);
      String ly = find(y);
      if(!lx.equals(ly))
      {
         if(rank.get(lx) > rank.get(ly))
         {
            parent.put(ly, lx); 
         }
         else if(rank.get(lx) < rank.get(ly))
         {
            parent.put(lx, ly); 
         }
         else
         {
            parent.put(lx, ly);
            rank.put(ly, rank.get(ly)+1);
         }
      }
  }
  
  public static String find(String st)
  {
      if(!parent.containsKey(st))
      {
         parent.put(st,st);
         rank.put(st, 1);
      }
      
      if(st.equals(parent.get(st)))
        return st;
    
      String temp = find(parent.get(st));
      parent.put(st, temp);
      return temp;
        
  }

}
