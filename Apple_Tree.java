import java.util.*;
public class Apple_Tree {
  static List<Integer>[] graph;
  static int[] count;
  static boolean[] visited;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      graph = new ArrayList[n+1];
      for(int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
      }
      for(int i = 1; i < n; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        graph[u].add(v);
        graph[v].add(u);
      }
      count = new int[n+1];
      visited = new boolean[n+1];
      dfs(1);
      int m = sc.nextInt();
      StringBuilder sb = new StringBuilder();
      while(m-- > 0) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        long ans = (long)count[x]*count[y];
        sb.append(ans).append("\n");
      }
      sb.deleteCharAt(sb.length()-1);
      System.out.println(sb.toString());
    }
    sc.close();
  }
  public static int dfs(int src) {
    if(graph[src].size() == 1 && src != 1) {
      count[src] = 1;
      return 1;
    }
    visited[src] = true;
    int c = 0;
    for(int nbrs: graph[src]) {
      if(!visited[nbrs]) {
        c += dfs(nbrs);
      }
    }
    visited[src] = false;
    count[src] = c;
    return c;
  }
}
