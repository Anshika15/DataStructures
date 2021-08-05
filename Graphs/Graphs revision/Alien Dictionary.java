import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String[] words = br.readLine().split(" ");

    System.out.println(alienOrder(words));
  }

  public static String alienOrder(String[] words) {


    HashMap<Character, HashSet<Character>> map = new HashMap<>();
    HashMap<Character, Integer> indegree = new HashMap<>();

    for (String s : words)
    {
      for (char ch : s.toCharArray())
      {
        indegree.put(ch, 0);
      }
    }


    for (int i = 0; i < words.length - 1; i++)
    {
      String curr = words[i];
      String next = words[i + 1];

      int len = Math.min(curr.length(), next.length());
      boolean flag = false;
      for (int j = 0; j < len; j++)
      {
        char ch1 = curr.charAt(j);
        char ch2 = next.charAt(j);

        if (ch1 != ch2)
        {
          if (map.containsKey(ch1))
          {
            HashSet<Character> set = map.get(ch1);
            if (!set.contains(ch2))
            {
              set.add(ch2);
              map.put(ch1, set);
              indegree.put(ch2, indegree.get(ch2) + 1);
            }
          }
          else
          {
            HashSet<Character> set = new HashSet<>();
            set.add(ch2);
            map.put(ch1, set);
            indegree.put(ch2, indegree.get(ch2) + 1);
          }

          flag = true;
          break;
        }
      }

      if (flag == false && curr.length() > next.length())
        return "";
    }

    StringBuilder sb = new StringBuilder();
    LinkedList<Character> q = new LinkedList<>();

    for (char ch : indegree.keySet())
    {
      if (indegree.get(ch) == 0)
        q.addLast(ch);
    }

    while (q.size() > 0)
    {
      char rem = q.removeFirst();
      sb.append(rem);
      if (map.containsKey(rem))
      {
        HashSet<Character> set = map.get(rem);

        for (char ch : set)
        {
          indegree.put(ch, indegree.get(ch) - 1);
          if (indegree.get(ch) == 0)
            q.add(ch);
        }
      }
    }

    if (sb.length() == indegree.size())
    {
      return sb.toString();
    }
    return "";
  }
}
