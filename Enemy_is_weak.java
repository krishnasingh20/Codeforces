import java.util.HashMap;
import java.util.Arrays;
public class Enemy_is_weak {
  public static void main(String[] args) {
    FastScanner sc = new FastScanner();
    Enemy_is_weak obj = new Enemy_is_weak();
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(obj.solve(n, arr));
  }
  public long solve(int n, int[] arr) {
    HashMap<Integer,Integer> compress = new HashMap<>();
    int idx = 1;
    int[] temp = arr.clone();
    Arrays.sort(temp);
    for(int i = 0; i < n; i++) {
      if(!compress.containsKey(temp[i])) {
        compress.put(temp[i], idx++);
      }
    }
    Fenwick ft = new Fenwick(idx-1);
    int[] left = new int[n];
    for(int i = 0; i < n; i++) {
      int id = compress.get(arr[i]);
      int r = ft.query(idx-1);
      int l = ft.query(id);
      left[i] = r - l;
      ft.update(id, 1);
    }
    ft = new Fenwick(idx-1);
    int[] right = new int[n];
    for(int i = n - 1; i >= 0; i--) {
      int id = compress.get(arr[i]);
      right[i] = ft.query(id);
      ft.update(id, 1);
    }
    long ans = 0;
    for(int i = 0; i < n; i++) {
      ans += (long)left[i]*right[i];
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
      while (i > 0) {
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
