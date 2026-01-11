import java.util.*;
public class Send_the_Fool_Further {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    graph = new ArrayList[n+1];
    for(int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for(int i = 0; i < n-1; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int c = sc.nextInt();
      graph[u].add(new int[]{v, c});
      graph[v].add(new int[]{u, c});
    }
    System.out.println(solve(n));
    sc.close();
  }
  static List<int[]>[] graph;
  static long ans;
  static boolean[] visited;
  public static long solve(int n) {
    visited = new boolean[n];
    ans = 0;
    dfs(0, 0);
    return ans;
  }
  public static void dfs(int src, long cost) {
    if(src != 0 && graph[src].size() == 1) {
      ans = Math.max(ans, cost);
      return;
    }
    visited[src] = true;
    for(int[] nbrs: graph[src]) {
      if(!visited[nbrs[0]]) {
        dfs(nbrs[0], cost+nbrs[1]);
      }
    }
  }
}
