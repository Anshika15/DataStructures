import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    HashMap<String, String> map = new HashMap<>();
    
    for(int i = 0; i < n; i++)
    {
        String str = scn.next();
        String str2 = scn.next();
        map.put(str,str2);
    }
    
    HashMap<String, HashSet<String>> tree = new HashMap<>(); // manager, emps under that manager
    String ceo = "";
    for(String emp : map.keySet())
    {
        String manager = map.get(emp);
        if(manager.equals(emp))
            ceo = emp;
        else
        {
            if(tree.containsKey(manager))
            {
                HashSet<String> set = tree.get(manager);
                set.add(emp);
            }
            else
            {
                HashSet<String> set = new HashSet<>();
                set.add(emp);
                tree.put(manager, set);
            }
        }
    }
    
    HashMap<String, Integer> res = new HashMap<>();
    
    getSize(tree, ceo, res);
    
    for(String man : res.keySet())
    {
        System.out.println(man + " " + res.get(man));
    }
    
  }
  
  public static int getSize(HashMap<String, HashSet<String>> tree, String manager,HashMap<String, Integer> res ){
      if(!tree.containsKey(manager)){
          res.put(manager, 0);
        return 1;
      }
      else
      {
          int size = 0;
          for(String emp: tree.get(manager))
          {
            int cs = getSize(tree, emp, res);
            size += cs;
          }
          res.put(manager, size);
          return size+1;
      }
      
  }

}
