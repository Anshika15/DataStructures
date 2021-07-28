import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    String[] st1 = br.readLine().split(" ");
    int src = Integer.parseInt(st1[0]);
    int dest = Integer.parseInt(st1[1]);
    System.out.println(numBusesToDestination(arr, src, dest));

  }

  public static int numBusesToDestination(int[][] routes, int S, int T) {


    int n = routes.length;

    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < routes[i].length; j++)
      {
        int busStop = routes[i][j];
        ArrayList<Integer> busNum = map.getOrDefault(busStop, new ArrayList<>());

        busNum.add(i);
        map.put(busStop, busNum);
      }
    }


    LinkedList<Integer> q = new LinkedList<>();
    HashSet<Integer> busNumVis = new HashSet<>();
    HashSet<Integer> busStopVis = new HashSet<>();

    q.add(S);
    busStopVis.add(S);
    int level = 0;

    while (q.size() > 0)
    {
      int size = q.size();
      while (size-- > 0)
      {
        int rem = q.removeFirst();

        if (rem == T)
          return level;

        ArrayList<Integer> buses = map.get(rem);
        for (int bus : buses) {
          if (busNumVis.contains(bus))
            continue;

          int busStops[] = routes[bus];
          for (int busStop : busStops)
          {
            if (busStopVis.contains(busStop))
              continue;
            q.add(busStop);
            busStopVis.add(busStop);
          }
          busNumVis.add(bus);
        }
      }
      level++;
    }
    return -1;

  }
}
