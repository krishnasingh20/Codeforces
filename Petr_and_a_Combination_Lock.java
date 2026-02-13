import java.io.*;
import java.util.*;
 
public class Petr_and_a_Combination_Lock {
 
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
 
        int T = fs.nextInt();
        while (T-- > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            out.append(solve(n, arr)).append('\n');
        }
 
        System.out.print(out);
    }
    static String solve(int n, int[] arr) {
        for(int i = 0; i < (1<<n); i++) {
            int curr = 0;
            for(int j = 0; j < n; j++) {
                if((i & (1<<j)) != 0) {
                    curr += arr[j];
                }
                else {
                    curr -= arr[j];
                }
            }
            if((curr+360) % 360 == 0) {
                return "YES";
            }
        }
        return "NO";
    }
}
