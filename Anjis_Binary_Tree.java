import java.io.*;
import java.util.*;

public class FasterInput_FasterOutput {
  public static class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String next() throws IOException {
      while (st == null || !st.hasMoreElements()) {
        st = new StringTokenizer(br.readLine());
      }
      return st.nextToken();
    }
    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }
  }
  static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
  public static void main(String[] args) throws Exception {
    FastScanner sc = new FastScanner();
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      ch = (sc.next()).toCharArray();
      P = new int[n+1];
      L = new int[n+1];
      R = new int[n+1];
      dp = new int[n+1];
      Arrays.fill(dp, -1);
      for(int i = 1; i <= n; i++) {
        int l = sc.nextInt();
        int r = sc.nextInt();
        L[i] = l;
        R[i] = r;
        if(l != 0) {
          P[l] = i;
        }
        if(r != 0) {
          P[r] = i;
        }
      }
      out.println(dfs(1));
      out.flush();
    }
  }
  static char[] ch;
  static int[] P;
  static int[] L;
  static int[] R;
  static int[] dp;
  public static int dfs(int p) {
    if(L[p] == 0 && R[p] == 0) {
      return 0;
    }
    if(dp[p] != -1) {
      return dp[p];
    }
    int a = Integer.MAX_VALUE;
    if(L[p] != 0) {
      a = dfs(L[p]);
      if(ch[p-1] != 'L') {
        a++;
      }
    }
    int b = Integer.MAX_VALUE;
    if(R[p] != 0) {
      b = dfs(R[p]);
      if(ch[p-1] != 'R') {
        b++;
      }
    }
    return dp[p] = Math.min(a, b);
  }
}
