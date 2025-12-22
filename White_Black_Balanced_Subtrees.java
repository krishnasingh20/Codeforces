import java.util.*;
public class White_Black_Balanced_Subtrees {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      List<Integer>[] tree = new ArrayList[n+1];
      for(int i = 1; i <= n; i++) {
        tree[i] = new ArrayList<>();
      }
      for(int i = 2; i <= n; i++) {
        int x = sc.nextInt();
        tree[x].add(i);
      }
      String s = sc.next();
      System.out.println(solve(n, tree, s));
    }
  }
  public static long solve(int n, List<Integer>[] tree, String s) {
    return dfs(1, tree, s).total;
  }
  public static Pair dfs(int src, List<Integer>[] tree, String s) {
    Pair sp = new Pair();
    if(s.charAt(src-1) == 'W') {
      sp.white++;
    }
    else {
      sp.black++;
    }
    for(int nbrs: tree[src]) {
      Pair p = dfs(nbrs, tree, s);
      sp.white += p.white;
      sp.black += p.black;
      sp.total += p.total;
    }
    if(sp.white == sp.black) {
      sp.total++;
    }
    return sp;
  }
  static class Pair {
    long white;
    long black;
    long total;
  }
}
