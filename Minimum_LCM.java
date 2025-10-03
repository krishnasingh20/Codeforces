
import java.io.*;
import java.util.*;

public class Minimum_LCM {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int T = 1;
        T = in.nextInt();
        while (T-- > 0) {
            input();
        }
        out.flush();
    }
    static void input() {
        long n = in.nextLong();
        out.println(solve(n));
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
    static String solve(long n) {
      if((n & 1) == 0) {//even
        return (n/2)+" "+(n/2);
      }
      long a = devisor(n);
      if(a == n) {//prime case
        return 1+" "+(n-1);
      }
      return (n/a)+" "+(n-(n/a));//odd
    }
    static long devisor(long n) {
      for(int i = 2; i*i <= n; i++) {
        if(n % i == 0) {
          return i;
        }
      }
      return n;
    }
}
