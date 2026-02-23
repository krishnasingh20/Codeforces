import java.io.*;
import java.util.*;
 
public class Parkour_Design {
 
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
            long x = fs.nextLong();
            long y = fs.nextLong();
            out.append(solve(x, y)).append('\n');
        }
        System.out.print(out);
    }
 
    static String solve(long x, long y) {
        if(y > x) {
            return "NO";
        }
        if(y < 0) {
            x -= Math.abs(y)*4;
            if(x < 0) {
                return "NO";
            }
            y = 0;
        }
        x -= (y*2);
        if(x < 0) {
            return "NO";
        }
        if(x % 3 == 0) {
            return "YES";
        }
        return "NO";
    }
}
