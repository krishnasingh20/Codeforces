import java.util.*;
public class Tree_Coloring {
  static List<Integer>[] tree;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      tree = new ArrayList[n+1];
      for(int i = 1; i <= n; i++) {
        tree[i] = new ArrayList<>();
      }
      for(int i = 1; i < n; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        tree[u].add(v);
        tree[v].add(u);
      }
      System.out.println(solve(n));
    }
    sc.close();
  }
  static boolean[] visited;
  static long ans;
  public static long solve(int n) {
    ans = 0;
    visited = new boolean[n+1];
    bfs();
    return ans;
  }
  public static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    visited[1] = true;
    while(!q.isEmpty()) {
      int size = q.size();
      ans = Math.max(ans, size);
      while(size-- > 0) {
        int rv = q.poll();
        int c = 0;
        for(int nbrs: tree[rv]) {
          if(!visited[nbrs]) {
            c++;
            visited[nbrs] = true;
            q.add(nbrs);
          }
        }
        ans = Math.max(ans, c+1);
      }
    }
  }
}
