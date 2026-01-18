import java.util.*;
public class Kefa_and_Park {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = 1;
    while(t-- > 0) {
      n = sc.nextInt();
      m = sc.nextInt();
      cats = new int[n+1];
      for(int i = 1; i <= n; i++) {
        cats[i] = sc.nextInt();
      }
      graph = new ArrayList[n+1];
      for(int i = 1; i <= n; i++){
        graph[i] = new ArrayList<>();
      }
      for(int i = 1; i < n; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        graph[u].add(v);
        graph[v].add(u);
      }
      System.out.println(solve());
    }
  }
  static int n;
  static int m;
  static int[] cats;
  static List<Integer>[] graph;
  static boolean[] visited;
  public static int solve() {
    Queue<Pair> q = new LinkedList<>();
    visited = new boolean[n+1];
    q.add(new Pair(1, cats[1]));
    while(!q.isEmpty()) {
      Pair rv = q.poll();
      visited[rv.vtx] = true;
      for(int nbrs: graph[rv.vtx]) {
        if(!visited[nbrs]) {
          int newC = cats[nbrs]==0?0:rv.cat+cats[nbrs];
          if(newC <= m) {
            q.add(new Pair(nbrs, newC));
          }
        }
      }
    }
    int ans = 0;
    for(int i = 2; i <= n; i++) {
      if(visited[i] && graph[i].size()==1) {
        ans++;
      }
    }
    return ans;
  }
  static class Pair {
    int vtx;
    int cat;
    Pair(int vtx, int cat) {
      this.vtx = vtx;
      this.cat = cat;
    }
  }
}
