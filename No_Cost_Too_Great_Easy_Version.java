import java.util.*;
public class No_Cost_Too_Great_Easy_Version {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while(T-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      for(int i = 0; i < n; i++) {
        int x = sc.nextInt();
      }
      if(flag) {
        flag = false;
        prime();
      }
      System.out.println(solve(n, arr));
    }
    sc.close();
  }
  static List<Integer>[] primeFac;
  static boolean flag = true;
  public static int solve(int n, int[] arr) {
    int ans = 2;
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < n; i++) {
      for(int div: primeFac[arr[i]]) {
        if(map.getOrDefault(div , 0) > 0) {
          ans = 0;
        }
        map.put(div, map.getOrDefault(div, 0)+1);
      }
    }
    for(int i = 0; i < n; i++) {
      for(int div: primeFac[arr[i]]) {
        map.put(div, map.get(div)-1);
      }
      for(int div: primeFac[arr[i]+1]) {
        if(map.getOrDefault(div, 0) > 0) {
          ans = Math.min(ans, 1);
        }
      }
      for(int div: primeFac[arr[i]]) {
        map.put(div, map.getOrDefault(div, 0)+1);
      }
    }
    return ans;
  }
  public static void prime() {
    primeFac = new ArrayList[200010];
    for(int i = 1; i < primeFac.length; i++) {
      int temp = i;
      primeFac[i] = new ArrayList<>();
      for(int x = 2; x*x <= i; x++) {
        if(temp % x == 0) {
          primeFac[i].add(x);
          while(temp % x == 0) {
            temp /= x;
          }
        }
      }
      if(temp > 1) {
        primeFac[i].add(temp);
      }
    }
  }
}
