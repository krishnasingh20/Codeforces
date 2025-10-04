import java.io.*;
import java.util.*;
 
public class Balanced_Bitstring {
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
        int k = in.nextInt();
        String s = in.next();
        out.println(solve(n, k, s));
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
    static String solve(int n, int k, String s) {
      char[] ch = s.toCharArray();
      for(int i = k; i < n; i++) {
        if(ch[i] == '0') {
          if(ch[i%k] == '1') {
            return "NO";
          }
          ch[i%k] = '0';
        }
        else if(ch[i] == '1') {
          if(ch[i%k] == '0') {
            return "NO";
          }
          ch[i%k] = '1';
        }
      }
      int c1 = 0;
      int c0 = 0;
      for(int i = 0; i < k; i++) {
        if(ch[i] == '1') {
          c1++;
        }
        else if(ch[i] == '0') {
          c0++;
        }
      }
      if(c1 > k/2 || c0 > k/2) {
        return "NO";
      }
      return "YES";
    }
}
