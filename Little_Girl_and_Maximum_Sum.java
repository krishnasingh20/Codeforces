import java.io.*;
import java.util.*;

public class Little_Girl_and_Maximum_Sum {

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

        int n = fs.nextInt();
        int q = fs.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        int[] diff = new int[n];

        for(int i = 0; i < q; i++) {
            int l = fs.nextInt();
            int r = fs.nextInt();
            l--;
            diff[l]++;
            if(r < n) {
                diff[r]--;
            }
        }

        for(int i = 1; i < n; i++) {
            diff[i] += diff[i-1];
        }

        Arrays.sort(arr);
        Arrays.sort(diff);

        long ans = 0;
        for(int i = 0; i < n; i++) {
            ans = ans + (long)arr[i]*diff[i];
        }

        System.out.println(ans);
    }
}
