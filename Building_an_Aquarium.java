import java.io.*;
import java.util.*;

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
      long x = in.nextLong();
      long[] arr = new long[n];
      for(int i = 0; i < n; i++) {
        arr[i] = in.nextLong();
      }
      out.println(solve(n, x, arr));
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
    static long solve(int n, long x, long[] arr) {
      Arrays.sort(arr);
      long ans = 0;
      long low = 1;
      long sum = 0;
      long high = 1000000000 + arr[0];
      while(low <= high) {
        long mid = low + (high - low)/2;
        long count = water(arr, mid);
        if(count <= x) {
          ans = mid;
          low = mid + 1;
        }
        else {
          high = mid - 1;
        }
      }
      return ans;
    }
    static long water(long[] arr, long h) {
      long amount = 0;
      for(long num: arr) {
        if(num < h) {
          amount += (h - num);
        }
      }
      return amount;
    }
}
