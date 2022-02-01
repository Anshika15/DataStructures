import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
      // write your code here
      int bucketIdx = hashFun(key);
      int dataIdx = getIndexWithInBucket(key, bucketIdx);
      
      if(dataIdx!= -1)
      {
         HMNode node = buckets[bucketIdx].get(dataIdx);
         node.value = value;
      }
      else
      {
        HMNode node = new HMNode(key, value);
        buckets[bucketIdx].add(node);
        size++;
      }
      
      double lambda = size * 1.0 / buckets.length;
      
      if(lambda > 2.0)
      {
          rehash();
      }
    }
    
    private void rehash() throws Exception{
        LinkedList<HMNode>[] oldBuck = buckets;
        
        initbuckets(oldBuck.length * 2);
        size = 0;
        
        for(int bi = 0; bi < oldBuck.length; bi++)
       {
          for(HMNode node : oldBuck[bi])
          {
            put(node.key, node.value);  
          }
       }
    }
    
    int getIndexWithInBucket(K key, int bidx)
    {
        int dtaIdx = 0;
        for(HMNode node : buckets[bidx])
        {
            if(node.key.equals(key))
                return dtaIdx;
            dtaIdx++;
        }
        return -1;
    }
    
    int hashFun(K key)
    {
        int hc = key.hashCode();
        return Math.abs(hc)% buckets.length;
    }

    public V get(K key) throws Exception {
      int bucketIdx = hashFun(key);
      int dataIdx = getIndexWithInBucket(key, bucketIdx);
      
      if(dataIdx!= -1)
      {
         HMNode node = buckets[bucketIdx].get(dataIdx);
         return node.value;
      }
      else
      {
        return null;
      }
    }

    public boolean containsKey(K key) {
      // write your code here
      int bucketIdx = hashFun(key);
      int dataIdx = getIndexWithInBucket(key, bucketIdx);
      
      if(dataIdx!= -1)
      {
         return true;
      }
      else
      {
        return false;
      }
    }

    public V remove(K key) throws Exception {
      // write your code here
      int bucketIdx = hashFun(key);
      int dataIdx = getIndexWithInBucket(key, bucketIdx);
      
      if(dataIdx!= -1)
      {
         HMNode node = buckets[bucketIdx].remove(dataIdx);
         size--;
         return node.value;
      }
      else
      {
        return null;
      }
    }

    public ArrayList<K> keyset() throws Exception {
      // write your code here
      ArrayList<K> keys = new ArrayList<K>();
      for(int bi = 0; bi < buckets.length; bi++)
      {
          for(HMNode node : buckets[bi])
          {
             keys.add(node.key); 
          }
      }
      return keys;
    }

    public int size() {
      // write your code here
      return size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
