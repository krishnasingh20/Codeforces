import java.io.*;
import java.util.*;

public class Move_Brackets {
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
      int n = in.nextInt();
      String s = in.next();
      out.println(solve(n, s));
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
    static long solve(int n, String s) {
      char[] ch = s.toCharArray();
      Stack<Character> st = new Stack<>();
      for(int i = 0; i < n; i++) {
        if(ch[i] == '(') {
          st.push('(');
        }
        else {
          if(!st.isEmpty() && st.peek() == '(') {
            st.pop();
          }
          else {
            st.push(')');
          }
        }
      }
      return st.size() / 2;
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
