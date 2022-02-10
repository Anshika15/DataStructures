import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String url=scn.nextLine();
    System.out.println(decode(encode(url)));
  }

  static HashMap<String , String> map = new HashMap<>();
    
    public static String encode(String longUrl)
    {
        StringBuilder sb = new StringBuilder();

        sb.append((char)(Math.floor(Math.random()*100)));

        while(map.containsKey(sb.toString()))
        {
          sb.append((char)(Math.floor(Math.random()*100)));
        }
        map.put(sb.toString(), longUrl);

        return sb.toString();
    }
    
    public static String decode(String shortUrl)
    {
      if(map.containsKey(shortUrl))
        return map.get(shortUrl);
      return "";
    }
}
