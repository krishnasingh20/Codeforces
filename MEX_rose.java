import java.util.*;
 
public class MEX_rose {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      HashMap<Integer, Integer> map = new HashMap<>();
      for(int i = 0; i < n; i++) {
        int x = sc.nextInt();
        map.put(x, map.getOrDefault(x, 0)+1);
      }
      System.out.println(solve(n, map, k));
    }
    sc.close();
  }
  public static long solve(int n, HashMap<Integer, Integer> map, int k) {
    int count = 0;
    int i = 0;
    while(i < k) {
      if(map.containsKey(i) == false) {
        count++;
      }
      i++;
    }
    if(map.getOrDefault(k, 0) == 0) {
      return count;
    }
    else {
      return Math.max(map.get(k), count);
    }
  }
}
