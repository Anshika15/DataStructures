import java.util.*;

public class Main {
    /* 
    
    Find And Replace Pattern
    
    1. Given a list of strings words and a string pattern.
2. Return a list of words[i] that match pattern. You may return the answer in any order.
3. A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
4. Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
    
    */

  public static List<String> findAndReplacePattern(String[] words, String pattern) {
    /* 
    
    travel on array of string if word will match the pattern add it to our result
    
    */
    
    List<String> result = new ArrayList<>();
    
    for(String word : words)
    {
        if(isMatch(word, pattern))
            result.add(word);
    }
    
    return result;
    
  }
  
  public static boolean isMatch(String word, String pattern)
  {
      if(pattern.length() != word.length())
        return false;
      HashMap<Character, Character> map = new HashMap<>(); // pattern char, word char
      HashSet<Character> isUsed = new HashSet<>(); // store word chars
      
      for(int i = 0; i < word.length(); i++)
      {
          char ch1 = word.charAt(i);
          char ch2 = pattern.charAt(i);
          
          if(map.containsKey(ch2))
          {
              if(map.get(ch2) != ch1)
                return false;
          }
          else
          {
              if(isUsed.contains(ch1))
                return false;
              map.put(ch2, ch1);
              isUsed.add(ch1);
          }
      }
      
      return true;
      
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String pattern = scn.nextLine();
    int n = scn.nextInt();
    scn.nextLine(); // to consume enter after number
    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = scn.nextLine();
    }
    List<String> res = findAndReplacePattern(words, pattern);
    if (res.size() == 0) {
      System.out.println("Empty");
      return;
    }
    Collections.sort(res);
    for (String str : res) {
      System.out.print(str + " ");
    }
    System.out.println();
  }
}
