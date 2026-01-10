import java.util.*;
public class The_Two_Routes {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    List<Integer>[]graph1 = new ArrayList[n+1];
    List<Integer>[]graph2 = new ArrayList[n+1];
    for(int i = 1; i <= n; i++) {
      graph1[i] = new ArrayList<>();
      graph2[i] = new ArrayList<>();
    }
    HashSet<String> set = new HashSet<>();
    while(m-- > 0) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      set.add((u+"/"+v));
      set.add((v+"/"+u));
      graph1[u].add(v);
      graph1[v].add(u);
    }
    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++) {
        if(i == j || set.contains((i+"/"+j))) {
          continue;
        }
        graph2[i].add(j);
      }
    }
    System.out.println(solve(n, m, graph1, graph2));
  }
  public static int solve(int n, int m, List<Integer>[] graph1, List<Integer>[] graph2) {
    if(m == 0 || m == (n*(n-1))/2) {
      return -1;
    }
    // precompute minium time path through railway
    int time1 = bfs(1, n, graph1);
    int time2 = bfs(1, n, graph2);
    if(time1 == -1 || time2 == -1) {
      return -1;
    }
    return Math.max(time1, time2);
  }
  public static int bfs(int src, int n, List<Integer>[] graph) {
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    boolean[] visited = new boolean[n+1];
    visited[1] = true;
    int time = 0;
    while(!q.isEmpty()) {
      int size = q.size();
      while(size-- > 0) {
        int rv = q.poll();
        if(rv == n) {
          return time;
        }
        for(int nbrs: graph[rv]) {
          if(!visited[nbrs]) {
            visited[nbrs] = true;
            q.add(nbrs);
          }
        }
      }
      time++;
    }
    return -1;
  }
}
  
