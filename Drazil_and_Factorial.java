import java.io.*;
import java.util.*;
public class Drazil_and_Factorial {
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
        //int T = fs.nextInt();
        int T = 1;
        while (T-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            out.append(solve(n, s)).append('\n');
        }
        System.out.print(out);
    }
    static final int[][] map = {{},{},{2},{3},{2,2,3},{5},{3,5},{7},{2,2,2,7},{2,3,3,7}};
    static String solve(int n, String s) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = s.charAt(i)-'0';
            if(x <= 1) {
                continue;
            }
            for(int l: map[x]) {
                ans.add(l);
            }
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for(int i = ans.size()-1; i >= 0; i--) {
            sb.append(ans.get(i));
        }
        return sb.toString();
    }
}
