import java.io.*;
import java.util.*;

public class Johnny_and_Ancient_Computer {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int T = in.nextInt();
        while (T-- > 0) {
            input();
        }
        out.flush();
    }

    static void input() {
        long a = in.nextLong();
        long b = in.nextLong();
        out.println(solve(a, b));
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
    static long solve(long a, long b) {
      HashSet<Long> set = new HashSet<>();
      set.add(a);
      long ans = 0;
      while(a != b) {
        if(a < b) {
          if(a*8 <= b) {
            a *= 8;
          }
          else if(a*4 <= b) {
            a *= 4;
          }
          else {
            a *= 2;
          }
        }
        else {
          if(a % 8 == 0 && a / 8 >= b) {
            a /= 8;
          }
          else if( a % 4 == 0 && a / 4 >= b) {
            a /= 4;
          }
          else if(a % 2 == 0 && a / 2 >= b) {
            a /= 2;
          }
        }
        if(set.contains(a)) {
          return -1;
        }
        set.add(a);
        ans++;
      }
      return ans;
    }
    static int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        long limit = (long) Math.sqrt(num);
        for (long i = 5; i <= limit; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
    static int divisor(int n) {
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) {
                return i;
            }
        }
        return n;
    }
}
