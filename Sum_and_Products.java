import java.util.*;
import java.io.*;

public class Sum_and_Products {
  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int T = in.nextInt();
    while (T-- > 0) {
        input();
        map.clear();
    }
    out.flush();
  }
  static HashMap<Long, Integer> map = new HashMap<>();
  static void input() {
    int n = in.nextInt();
    for(int i = 0; i < n; i++) {
      long x = in.nextLong();
      map.put(x, map.getOrDefault(x, 0)+1);
    }
    StringBuilder sb = new StringBuilder();
    int q = in.nextInt();
    while(q-- > 0) {
      long x = in.nextLong();
      long y = in.nextLong();
      sb.append(solve(x, y)).append(" ");
    }
    out.println(sb.toString().trim());
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
  
  public static long solve(long x, long y) {
    long d = x*x - 4*y;
    long D = (long)Math.sqrt(d);
    if(D*D != d) {
      return 0;
    }
    long a = (x+D)/2;
    long b = (x-D)/2;
    if((a+b) != x || (a*b) != y) {
      return 0;
    }
    int a1 = map.getOrDefault(a, 0);
    int b1 = map.getOrDefault(b, 0);
    if(a == b) {
      return (long)a1*(b1 - 1)/2;
    }
    return (long)a1*b1;
  }
}
