import java.io.*;
import java.util.*;
 
public class Line_Trip {
 
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
 
        int T = fs.nextInt();
        while (T-- > 0) {
            int n = fs.nextInt();
            int x = fs.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
 
            out.append(solve(n, x, arr)).append('\n');
        }
 
        System.out.print(out);
    }
 
    static int solve(int n, int x, int[] arr) {
        int ans = 0;
        int low = 1;
        int high = 100;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(possible(mid, x, n, arr)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static boolean possible(int cap, int x, int n, int[] arr) {
        int si = 0;
        int cap1 = cap;
        for(int i = 0; i < n; i++) {
            if(cap1 < arr[i] - si) {
                return false;
            }
            cap1 -= (arr[i] - si);
            cap1 = Math.min(cap, cap1+arr[i]);
            si = arr[i];
        }
        if(si+cap1 < x) {
            return false;
        }
        cap1 -= (x-si);
        si = x;
        for(int i = n-1; i >= 0; i--) {
            if(cap1 < si - arr[i]) {
                return false;
            }
            cap1 -= (si-arr[i]);
            cap1 = Math.min(cap, cap1+arr[i]);
            si = arr[i];
        }
        if(si - cap1 > 0) {
            return false;
        }
        return true;
    }
}
