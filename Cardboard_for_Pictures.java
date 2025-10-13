import java.io.*;
import java.util.*;
import java.math.BigInteger;

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
      long c = in.nextLong();
      long[] arr = new long[n];
      for(int i = 0; i < n; i++) {
        arr[i] = in.nextLong();
      }
      out.println(solve(n, c, arr));
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
    static long solve(int n, long c, long[] arr) {
      long low = 1;
      long high = 1000000000000L;
      BigInteger target = BigInteger.valueOf(c);
      while(low <= high) {
        long mid = low + (high - low)/2;
        BigInteger area = areaCover(arr, mid);
        long cmp = area.compareTo(target);
        if(cmp == 0) {
          return mid;
        }
        else if(cmp > 0) {
          high = mid - 1;
        }
        else {
          low = mid + 1;
        }
      }
      return -1;
    }
    static BigInteger areaCover(long[] arr, long w) {
      BigInteger area = BigInteger.ZERO;
      for(long num: arr) {
        BigInteger a = BigInteger.valueOf(num + 2*w);
        area = area.add(a.multiply(a));
      }
      return area;
    }
}
