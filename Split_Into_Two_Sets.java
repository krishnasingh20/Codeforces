import java.util.*;
public class Split_Into_Two_Sets {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      graph = new ArrayList[n+1];
      for(int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
      }
      boolean flag = false;
      for(int i = 0; i < n; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a==b) {
          flag = true;
        }
        graph[a].add(b);
        graph[b].add(a);
        if(graph[a].size() > 2 || graph[b].size() > 2) {
          flag = true;
        }
      }
      if(flag) {//self loop case and more then 2 time any number occure it can not divide into two set
        System.out.println("NO");
        continue;
      }
      System.out.println(solve(n));
    }
  }
  static List<Integer>[] graph;
  public static String solve(int n) {
    HashMap<Integer, Integer> visited = new HashMap<>();
    Queue<Pair> q = new LinkedList<>();
    for(int i = 1; i <= n; i++) {
      if(visited.containsKey(i)) {
        continue;
      }
      q.add(new Pair(i, 0));
      while(!q.isEmpty()) {
        Pair rv = q.poll();
        if(visited.containsKey(rv.vtx)) {
          if(visited.get(rv.vtx) != rv.dis) {//odd length cycle
            return "NO";
          }
          continue;//even length cycle
        }
        visited.put(rv.vtx, rv.dis);
        for(int nbrs: graph[rv.vtx]) {
          if(!visited.containsKey(nbrs)) {
            q.add(new Pair(nbrs, rv.dis+1));
          }
        }
      }
    }
    return "YES";
  }
  static class Pair{
    int vtx;
    int dis;
    Pair(int vtx, int dis) {
      this.vtx = vtx;
      this.dis = dis;
    }
  }
}
  
