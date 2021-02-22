class Solution {

    int search(String pat, String txt) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < pat.length(); i++)
        {
            if(!map.containsKey(pat.charAt(i)))
                map.put(pat.charAt(i), 1);
            else
            {
                int c = map.get(pat.charAt(i));
                c += 1;
                map.replace(pat.charAt(i), c);
            }
        }
        
       // System.out.println(map);
        int count = map.size();
        int ans = 0;
        int i = 0, j = 0;
        while(j < txt.length())
        {
            if(map.containsKey(txt.charAt(j)))
            {
                int c = map.get(txt.charAt(j));
                c -= 1;
                map.replace(txt.charAt(j), c);
                if(c == 0)
                    count--;
            }
           // System.out.println(map);
            if(j - i + 1 < pat.length())
            {
                j++;
            }
            else if(j - i + 1 == pat.length())
            {
                if(count == 0)
                    ans++;
                if(map.containsKey(txt.charAt(i)))
                {
                     int c = map.get(txt.charAt(i));
                     c += 1;
                     map.replace(txt.charAt(i), c);
                     if(c == 1)
                        count++;
                }
                i++;
                j++;
            }
            
        }
       // System.out.println(map);
        return ans;
    }
}
