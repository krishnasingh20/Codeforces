import java.io.*;
import java.util.*;

public class New_Year_and_Old_Property {

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
        int T = fs.nextInt();
        while (T-- > 0) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            out.append(solve(a, b)).append('\n');
        }
        System.out.print(out);
    }

    static long solve(long a, long b) {
        String l = Long.toBinaryString((a-1));
        String r = Long.toBinaryString(b);
        int len = Math.max(l.length(), r.length());
        long[][][][] dp = new long[len][2][2][len];
        for(long[][][] d: dp) {
            for(long[][] d1: d) {
                for(long[] d2: d1) {
                    Arrays.fill(d2, -1);
                }
            }
        }
        long count1 = count(l, 0, 1, 1, 0, dp);
        for(long[][][] d: dp) {
            for(long[][] d1: d) {
                for(long[] d2: d1) {
                    Arrays.fill(d2, -1);
                }
            }
        }
        long count2 = count(r, 0, 1, 1, 0, dp);
        return count2 - count1;
    }

    static long count(String s, int i, int t, int lz, int c, long[][][][] dp) {
        if(i == s.length()) {
            if(c == 1) {
                return 1;
            }
            return 0;
        }
        if(t == 0 && lz == 0 && dp[i][t][lz][c] != -1) {
            return dp[i][t][lz][c];
        }
        int lb = 0;
        int ub = (t==1)?(s.charAt(i)-'0'):1;
        long ans = 0;
        for(int d = lb; d <= ub; d++) {
            int newT = (t==1 && d==ub)?1:0;
            int newLZ = (lz==1 && d==0)?1:0;
            int c1 = (lz==0 && d==0)?1:0;
            ans += count(s, i+1, newT, newLZ, c+c1, dp);
        }
        if(t == 0 && lz == 0) {
            dp[i][t][lz][c] = ans;
        }
        return ans;
    }
}
