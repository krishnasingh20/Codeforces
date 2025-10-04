import java.io.*;
import java.util.*;

public class Red_Versus_Blue {
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
        int r = in.nextInt();
        int b = in.nextInt();
        out.println(solve(n, r, b));
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
    
    static String solve(int n, int r, int b) {
      int num = r % (b+1);
      int max = r / (b+1);
      int max1 = max+(num==0?0:1);
      StringBuilder sb = new StringBuilder();
      for(int i = 1; i <= num; i++) {
        int j = max1;
        while(j > 0) {
          sb.append('R');
          j--;
        }
        sb.append('B');
      }
      int left = (b+1) - num;
      for(int i = 0; i < left; i++) {
        int j = max;
        while(j > 0) {
          sb.append('R');
          j--;
        }
        sb.append('B');
      }
      sb.deleteCharAt(sb.length()-1);
      return sb.toString();
    }
    
}
