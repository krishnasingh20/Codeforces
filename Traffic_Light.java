import java.util.*;
import java.io.*;

public class Main {
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
    char c = in.next().charAt(0);
    String s = in.next();
    out.println(solve(n, c, s));
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
  
  public static int solve(int n, char c, String s) {
    if(c == 'g') {
      return 0;
    }
    char[] ch = s.toCharArray();
    int i = 0;
    while(i < n && ch[i] != 'g') {
      i++;
    }
    i += n;
    int ans = 0;
    for(int j = n - 1; j >= 0; j--) {
      if(ch[j] == 'g') {
        i = j;
      }
      else if(ch[j] == c) {
        ans = Math.max(ans, i - j);
      }
    }
    return ans;
  }
}
