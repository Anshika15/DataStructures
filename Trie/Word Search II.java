import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    
  public static class Node{
      Node[] childs;
      String str;
      int count;
      Node(){
          childs = new Node[26];
      }
  }
  
   public static void insert(String word)
    {
        Node curr = root;
        for(char ch : word.toCharArray())
        {
         if(curr.childs[ch - 'a'] == null){
            curr.childs[ch - 'a'] = new Node();
            curr.count++;
         }
         curr = curr.childs[ch - 'a'];
        }
        curr.str = word;
    }
  
  public static final Node root = new Node();
  public static ArrayList<String> findWords(char[][] board, String[] words) {
    
    for(String word : words)
    {
        insert(word);
    }
    
    boolean vis[][] = new boolean[board.length][board[0].length];
    
    ArrayList<String> ans = new ArrayList<>();
    for(int i = 0; i < board.length; i++)
    {
        for(int j = 0; j < board[i].length; j++)
        {
            dfs(board, i, j, root, ans, vis);
        }
    }
    return ans;
  }
  
  public static void dfs(char[][] board, int i, int j, Node node, ArrayList<String> ans, boolean vis[][])
  {
      if(i < 0 || j < 0 || i >= board.length || j >= board[0].length|| vis[i][j] == true || node.count == 0)
        return;
        
      if(node.childs[board[i][j] - 'a'] == null)
        return;
        
      Node child = node.childs[board[i][j] - 'a'];
      if(child.str != null)
      {
         // if(!ans.contains(child.str)) // to remove duplicacy or we can keep a count of childs to remove duplicate elements
            ans.add(child.str);
            child.str = null;
      }
      
      vis[i][j] = true;
      
      dfs(board, i+1, j, child, ans, vis);
      dfs(board, i-1, j, child, ans, vis);
      dfs(board, i, j+1, child, ans, vis);
      dfs(board, i, j-1, child, ans, vis);
      
      vis[i][j] = false;
      
      if(child.count == 0) // if child count is zero inform the parent to not use it
      {
          node.count--;
      }
  }
  

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int m = Integer.parseInt(read.readLine());
    char[][]board = new char[n][];
    for (int i = 0; i < n; i++) {
      board[i] = read.readLine().trim().toCharArray();
    }
    int count = Integer.parseInt(read.readLine());
    String words[] = new String[count];
    for (int i = 0; i < count; i++) {
      words[i] = read.readLine();
    }

    ArrayList<String> result = findWords(board, words);
    Collections.sort(result);
    System.out.println(result);

  }
}
