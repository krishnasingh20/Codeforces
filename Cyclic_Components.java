import java.util.*;
public class Cyclic_Components {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    graph = new ArrayList[n+1];
    degree = new int[n+1];
    for(int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }
    for(int i = 0; i < m; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      degree[u]++;
      degree[v]++;
      graph[u].add(v);
      graph[v].add(u);
    }
    System.out.println(solve(n, m));
    sc.close();
  }
  static List<Integer>[] graph;
  static int[] degree;
  public static long solve(int n, int m) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[n+1];
    long ans = 0;
    for(int i = 1; i <= n; i++) {
      if(visited[i]) {
        continue;
      }
      q.add(i);
      boolean flag = false;
      while(!q.isEmpty()) {
        int rv = q.poll();
        if(visited[rv]) {
          continue;
        }
        if(degree[rv] != 2) {
          flag = true;
        }
        visited[rv] = true;
        for(int nbrs: graph[rv]) {
          if(!visited[nbrs]) {
            q.add(nbrs);
          }
        }
      }
      if(!flag) {
        ans++;
      }
    }
    return ans;
  }
}
