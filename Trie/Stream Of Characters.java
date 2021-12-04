/*
Implement the StreamChecker class as follows:

1. StreamChecker(words): Constructor, init the data structure with the given words.
2. query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
*/
import java.io.*;
import java.util.*;

public class Main {
  public static class StreamChecker {
      
    public static class Node{
        /* suffix trie */
        Node[] childs = new Node[26];
        boolean isEnd = false;
    }
    
    private final Node root;
    private final StringBuilder sb;
    public StreamChecker(String[] words) {
        
        root = new Node();
        sb = new StringBuilder();
        
        for(String s : words)
        {
            Node curr = root;
            for(int i = s.length()-1; i >= 0; i--)
            {
                char ch = s.charAt(i);
                if(curr.childs[ch-'a'] == null)
                {
                    curr.childs[ch-'a'] = new Node();
                }
                curr = curr.childs[ch-'a'];
            }
            
            curr.isEnd = true;
        }
    }

    public boolean query(char letter) {
        
        sb.append(letter);
        Node curr = root;
        for(int i = sb.length()-1; i >= 0; i--)
        {
            char ch = sb.charAt(i);
            curr = curr.childs[ch-'a'];
            if(curr == null) // if prev char is not present return false
                return false;
            if(curr.isEnd == true) // if we reached the end of word and till now we found all chars of word in trie return true
                return true;
        }
        return false;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    String[]words = new String[n];

    for (int i = 0; i < n; i++) {
      words[i] = read.readLine();
    }

    StreamChecker obj = new StreamChecker(words);

    n = Integer.parseInt(read.readLine());
    for (int i = 0; i < n; i++) {
      System.out.println(obj.query(read.readLine().charAt(0)));
    }
  }
}
