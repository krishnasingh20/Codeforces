import java.io.*;
import java.util.*;
 
public class String_Rotation_Game {
 
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
        int T = 1;
        T = fs.nextInt();
        while (T-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            out.append(solve(n, s)).append('\n');
        }
        System.out.print(out);
    }
 
    static int solve(int n, String s) {
        char[] ch = s.toCharArray();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int c1 = 0;
            int c2 = 0;
            char prev = 'A';
            for(int j = 0; j <= i; j++) {
                if(ch[j] != prev) {
                    c1++;
                    prev = ch[j];
                }
            }
            prev = 'A';
            for(int j = i+1; j < n; j++) {
                if(ch[j] != prev) {
                    c2++;
                    prev = ch[j];
                }
            }
            int c = c1+c2;
            if(i < n-1 && ch[n-1] == ch[0]) {
                c--;
            }
            ans = Math.max(ans, c);
        }
        return ans;
    }
}
