import java.io.*;
import java.util.*;
 
public class All_in_one_gun {
 
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
            int n = fs.nextInt();
            long h = fs.nextLong();
            long k = fs.nextLong();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            out.append(solve(n, h, k, arr)).append('\n');
        }
        System.out.print(out);
    }
 
    static long solve(int n, long h, long k, int[] arr) {
        long sum = 0;
        for(int a: arr) {
            sum += a;
        }
        if(h % sum == 0) {
            long ans = (h/sum)*n + ((h/sum)-1)*k;
            return ans;
        }
        long ans = (h/sum)*n + (h/sum)*k;
        long req = h % sum;
        int[] max = new int[n];
        max[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--) {
            max[i] = Math.max(max[i+1], arr[i]);
        }
        long curr = 0;
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(i==n-1) {
                ans += n;
                return ans;
            }
            else{
                min = Math.min(min, arr[i]);
                if(curr+arr[i]-min+max[i+1] >= req || curr+arr[i] >= req) {
                    ans += (i+1);
                    return ans;
                }
                curr += arr[i];
            }
        }
        return -1L;
    }
}
