import java.util.HashMap;
public class Pashmak_and_Parmida's_problem {
  public static void main(String[] args) {
    FastScanner sc = new FastScanner();
    Pashmak_and_Parmidas_problem obj = new Pashmak_and_Parmidas_problem();
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(obj.solve(n, arr));
  }
  public long solve(int n, int[] arr) {
    HashMap<Integer, Integer> map1 = new HashMap<>();
    int max = 0;
    for (int i = 0; i < n; i++) {
      map1.put(arr[i], map1.getOrDefault(arr[i], 0) + 1);
      max = Math.max(max, map1.get(arr[i]));
    }
    HashMap<Integer, Integer> map2 = new HashMap<>();
    Fenwick ft = new Fenwick(max);
    long ans = 0;
    for (int i = 0; i < n; i++) {
      int prev = map2.getOrDefault(arr[i], 0);
      int curr = map1.get(arr[i]) - prev;
      ans += (ft.query(max) - ft.query(curr));
      map2.put(arr[i], prev + 1);
      ft.update(prev + 1, 1);
    }
    return ans;
  }
  class Fenwick {
    int n;
    int[] bit;
    public Fenwick(int n) {
      this.n = n;
      bit = new int[n + 1];
    }
    public void update(int i, int val) {
      while (i <= n) {
        bit[i] += val;
        i += (i & -i);
      }
    }
    public int query(int i) {
      int sum = 0;
      while (i >= 1) {
        sum += bit[i];
        i -= (i & -i);
      }
      return sum;
    }
  }
  static class FastScanner {
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;
    private int read() {
      if (ptr >= len) {
        try {
          len = System.in.read(buffer);
          ptr = 0;
          if (len <= 0) return -1;
        } catch (Exception e) {
          return -1;
        }
      }
      return buffer[ptr++];
    }
    int nextInt() {
      int c, sign = 1, val = 0;
      do {
          c = read();
      } while (c <= ' ');

      if (c == '-') {
          sign = -1;
          c = read();
      }

      while (c > ' ') {
          val = val * 10 + (c - '0');
          c = read();
      }
      return val * sign;
    }
  }
}
