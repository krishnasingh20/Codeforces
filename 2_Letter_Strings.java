
import java.io.*;
import java.util.*;

public class 2_Letter_Strings {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int T = 1;
        T = in.nextInt();
        while (T-- > 0) {
            input();
        }
        out.flush();
    }
    static void input() {
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
          arr[i] = in.next();
        }
        out.println(solve(n, arr));
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
    static long solve(int n, String[] arr) {
      HashMap<String, Integer> map = new HashMap<>();
      long ans = 0;
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < 11; j++) {
         if(arr[i].charAt(1) != (char)(j+'a')) {
           ans += map.getOrDefault(arr[i].charAt(0)+""+(char)(j+'a'), 0);
           
         }
        }
        for(int j = 0; j < 11; j++) {
          if(arr[i].charAt(0) != (char)(j+'a')) {
            ans += map.getOrDefault((char)(j+'a')+""+arr[i].charAt(1), 0);
          }
        }
        map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
      }
      return ans;
    }
}
