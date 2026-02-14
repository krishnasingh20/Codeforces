import java.io.*;
import java.util.*;
public class Swap_Adjacent_Elements {
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
        String next() {
            StringBuilder sb = new StringBuilder();
            int c;
            do { c = read(); } while (c <= ' ');
            while (c > ' ') {
                sb.append((char)c);
                c = read();
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
//        int T = fs.nextInt();
        int T = 1;
        while (T-- > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            String s = fs.next();
            out.append(solve(n, arr, s)).append('\n');
        }
        System.out.print(out);
    }
    static String solve(int n, int[] arr, String s) {
        int i = 0;
        int max = -1;
        while(i < n) {
            if(i < n-1 && s.charAt(i) == '1') {
                int min1 = arr[i];
                int max1 = arr[i];
                while(i < n-1 && s.charAt(i) == '1') {
                    min1 = Math.min(min1, arr[i]);
                    max1 = Math.max(max1, arr[i]);
                    i++;
                }
                if(i < n) {
                    min1 = Math.min(min1, arr[i]);
                    max1 = Math.max(max1, arr[i]);
                    i++;
                }
                if(min1 < max) {
                    return "NO";
                }
                max = max1;
            }
            else {
                if(i > 0 && (arr[i] < arr[i-1] || arr[i] < max)) {
                    return "NO";
                }
                max = arr[i];
                i++;
            }
        }
        return "YES";
    }
}
