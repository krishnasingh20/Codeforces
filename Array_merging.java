import java.util.*;
import java.io.*;

public class Array_merging {
  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int T = in.nextInt();
    while (T-- > 0) {
        input();
    }
    out.flush();
  }

  static void input() {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for(int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for(int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }
    StringBuilder str = new StringBuilder();
    str.append(solve(n, a, b)).append("\n");
    out.print(str.toString());
  }
  
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try { st = new StringTokenizer(br.readLine()); }
            catch (IOException e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try { str = br.readLine(); }
        catch (IOException e) { e.printStackTrace(); }
        return str;
    }
  }
  public static long solve(int n, int[] a, int[] b) {
    HashMap<Integer, Integer> map1 = new HashMap<>();
    HashMap<Integer, Integer> map2 = new HashMap<>();
    int c = 1;
    for(int i = 1; i < n; i++) {
      if(a[i] != a[i-1]) {
        map1.put(a[i-1], Math.max(c, map1.getOrDefault(a[i-1], 0)));
        c = 1;
        continue;
      }
      c++;
    }
    map1.put(a[n-1], Math.max(c, map1.getOrDefault(a[n-1], 0)));
    c = 1;
    for(int i = 1; i < n; i++) {
      if(b[i] != b[i-1]) {
        map2.put(b[i-1], Math.max(c, map2.getOrDefault(b[i-1], 0)));
        c = 1;
        continue;
      }
      c++;
    }
    map2.put(b[n-1], Math.max(c, map2.getOrDefault(b[n-1], 0)));
    long ans = 0;
    HashSet<Integer> set = new HashSet<>();
    set.addAll(map1.keySet());
    set.addAll(map2.keySet());
    for(int num: set) {
      int x = map1.getOrDefault(num, 0);
      int y = map2.getOrDefault(num, 0);
      ans = Math.max(ans, (long)x+y);
    }
    return ans;
  }
}
