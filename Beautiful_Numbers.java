import java.io.*;
import java.util.*;
 
public class Beautiful_Numbers {
 
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
        int T = 1;
        T = fs.nextInt();
        while (T-- > 0) {
            long n = fs.nextLong();
            List<Integer> ll = new ArrayList<>();
            while(n > 0) {
                int rem = (int)(n % 10);
                ll.add(rem);
                n /= 10;
            }
            Collections.reverse(ll);
            out.append(solve(ll)).append('\n');
        }
        System.out.print(out);
    }
 
    static long solve(List<Integer> ll) {
        int sum = 0;
        for(int l: ll) {
            sum += l;
        }
        int f1 = sum;
        int f2 = digitSum(f1);
        if(f1 == f2) {
            return 0;
        }
        int n = ll.size();
        dp = new Long[n][9*n + 1];
        return minOper(ll, 0, 0);
    }
    
    static Long[][] dp;
    static long minOper(List<Integer> ll, int i, int sum) {
        if(sum > 9) {
            return Integer.MAX_VALUE;
        }
        if(i == ll.size()) {
            return 0;
        }
        if(dp[i][sum] != null) {
            return dp[i][sum];
        }
        long ans = Integer.MAX_VALUE;
        int lb = (i == 0)?1:0;
        int ub = 9;
        for(int d = lb; d <= ub; d++) {
            int newSum = sum + d;
            long curr = minOper(ll, i+1, newSum);
            if(d != ll.get(i)) {
                curr++;
            }
            ans = Math.min(ans, curr);
        }
        return dp[i][sum] = ans;
    }
    
    static int digitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
