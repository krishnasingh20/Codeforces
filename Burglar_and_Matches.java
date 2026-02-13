import java.io.*;
import java.util.*;
 
public class Burglar_and_Matches {
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private int read() {
            if (ptr >= len) {
                try {
                    len = System.in.read(buffer);
                    ptr = 0;
                    if (len <= 0) return -1;
                } catch (IOException e) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }
        int nextInt() {
            int c, sign = 1, val = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
        long nextLong() {
            int c;
            long sign = 1, val = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        // int T = fs.nextInt();
        int T = 1;
        while (T-- > 0) {
            long n = fs.nextLong();
            int m = fs.nextInt();
            long[][] arr = new long[m][2];
            for (int i = 0; i < m; i++) {
              arr[i][0] = fs.nextLong();
              arr[i][1] = fs.nextLong();
            }
            out.append(solve(n, m, arr)).append('\n');
        }
        System.out.print(out);
    }
    static long solve(long n, int m, long[][] arr) {
      Arrays.sort(arr, (a, b)->Long.compare(b[1], a[1]));
      long ans = 0;
      for(int i = 0; i < m; i++) {
        if(arr[i][0] >= n) {
          ans += n*arr[i][1];
          return ans;
        }
        ans += (arr[i][0]*arr[i][1]);
        n -= arr[i][0];
      }
      return ans;
    }
}
