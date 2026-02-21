import java.io.*;
import java.util.*;
 
public class Three_Activity {
 
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
    }
 
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int T = 1;
        T = fs.nextInt();
        while (T-- > 0) {
            int n = fs.nextInt();
            int[][] arr = new int[n][3];
            for(int i = 0; i < n; i++) {
                arr[i][0] = fs.nextInt();
            }
            for(int i = 0; i < n; i++) {
                arr[i][1] = fs.nextInt();
            }
            for(int i = 0; i < n; i++) {
                arr[i][2] = fs.nextInt();
            }
            out.append(solve(arr, n)).append('\n');
        }
        System.out.print(out);
    }
 
    static long solve(int[][] arr, int n) {
        dp = new Long[n][4][2][2][2];
        return activity(arr, 0, 3, 0, 0, 0);
    }
    static Long[][][][][] dp;
    static long activity(int[][] arr, int i, int k, int s1, int s2, int s3) {
        if(k == 0) {
            return 0;
        }
        if(i == arr.length) {
            return Long.MIN_VALUE;
        }
        if(dp[i][k][s1][s2][s3] != null) {
            return dp[i][k][s1][s2][s3];
        }
        long ans = Long.MIN_VALUE;
        if(s1 == 0) {
            long next = activity(arr, i+1, k-1, 1, s2, s3);
            if(next != Long.MIN_VALUE) {
                next += arr[i][0];
            }
            ans = Math.max(ans, next);
        }
        if(s2 == 0) {
            long next = activity(arr, i+1, k-1, s1, 1, s3);
            if(next !=  Long.MIN_VALUE) {
                next += arr[i][1];
            }
            ans = Math.max(ans, next);
        }
        if(s3 == 0) {
            long next = activity(arr, i+1, k-1, s1, s2, 1);
            if(next != Long.MIN_VALUE) {
                next += arr[i][2];
            }
            ans = Math.max(ans, next);
        }
        long skip = activity(arr, i+1, k, s1, s2, s3);
        return dp[i][k][s1][s2][s3] = Math.max(ans, skip);
    }
}
