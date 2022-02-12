/*
Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        LinkedList<String> q = new LinkedList<>();
        q.add(beginWord);
        
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
        int level = 0;
        
        while(q.size() > 0)
        {
            level++;
            if(q.contains(endWord))
            {
                return level;
            }
            int size = q.size();
            while(size-- > 0)
            {
                String curr = q.removeFirst();
                StringBuilder sb = new StringBuilder(curr);
                for(int i = 0; i < curr.length(); i++)
                {
                    for(char ch = 'a'; ch <= 'z'; ch++)
                    {
                        sb.setCharAt(i, ch);
                        if(set.contains(sb.toString()))
                        {
                            q.add(sb.toString());
                            set.remove(sb.toString());
                        }
                    }
                    sb.setCharAt(i, curr.charAt(i));
                }
            }
        }
        
        return 0;
        
    }
}
