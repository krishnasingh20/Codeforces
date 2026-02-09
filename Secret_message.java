import java.util.*;
public class Secret_message {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      String[] arr = new String[k];
      for(int i = 0; i < k; i++) {
        arr[i] = sc.next();
      }
      System.out.println(solve(n, k, arr));
    }
  }
  public static String solve(int n, int k, String[] arr) {
    int[] mask = new int[n];
    int[] mask1 = new int[n];
    for(int i = 0; i < n; i++) {
      int newMask = 0;
      for(int j = 0; j < k; j++) {
        int x = arr[j].charAt(i)-'a';
        newMask |= (1<<x);
      }
      mask[i] = newMask;
    }
    List<Integer> ll = factors(n);
    StringBuilder sb = new StringBuilder();
    int ans = -1;
    for(int d: ll) {
      for(int i = 0; i < d; i++) {
        mask1[i] = mask[i];
      }
      boolean flag = false;
      for(int i = d; i < n; i++) {
        int j = i % d;
        if((mask1[j] & mask[i]) == 0) {
          flag = true;
          break;
        }
        mask1[j] = (mask1[j] & mask[i]);
      }
      if(!flag) {
        ans = d;
        break;
      }
    }
    for(int i = 0; i < ans; i++) {
      int idx = 0;
      int m = mask1[i];
      while(m > 0) {
        if((m & 1) != 0) {
          break;
        }
        idx++;
        m >>= 1;
      }
      sb.append((char)(idx+'a'));
    }
    String s = sb.toString();
    while(sb.length() < n) {
      sb.append(s);
    }
    return sb.toString();
  }
  public static List<Integer> factors(int n) {
    int limit = (int)Math.sqrt(n);
    List<Integer> ll = new ArrayList<>();
    for(int i = 1; i <= limit; i++) {
      if(n % i == 0) {
        ll.add(i);
        if(n % (n/i) == 0 && (n/i) != i) {
          ll.add((n/i));
        }
      }
    }
    Collections.sort(ll);
    return ll;
  }
}
