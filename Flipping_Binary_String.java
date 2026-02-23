import java.io.*;
import java.util.*;

public class Flipping_Binary_String {

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
            while ((c = read()) != -1 && c <= ' ') {
            }
            if (c == -1) return null;
            do {
                sb.append((char) c);
                c = read();
            } while (c != -1 && c > ' ');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int T = 1;
        T = fs.nextInt();
        while (T-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            out.append(solve(n, s)).append('\n');
        }
        System.out.print(out);
    }

    static String solve(int n, String s) {
        StringBuilder sb = new StringBuilder();
        int one = 0;
        int zero = 0;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zero++;
                idx = i;
            } else {
                one++;
            }
        }
        if(one == n-1) {
            sb.append(1).append('\n');
            sb.append((idx+1));
            return sb.toString();
        }
        char c = '1';
        if((one & 1) == 1) {
            if((zero & 1) == 0) {
                return "-1";
            }
            c = '0';
            one = zero;
        }
        sb.append(one).append('\n');
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == c) {
                sb.append((i+1)).append(' ');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
