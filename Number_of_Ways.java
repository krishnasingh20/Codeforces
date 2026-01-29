import java.util.*;
public class Number_of_Ways {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(solve(n, arr));
  }
  public static long solve(int n, int[] arr) {
    long sum = 0;
    for(int a: arr) {
      sum += a;
    }
    if(sum % 3 != 0) {
      return 0;
    }
    long target = sum/3;
    HashMap<Long, Integer> map = new HashMap<>();
    long prefixSum = 0;
    long ans = 0;
    for(int i = 0; i < n-1; i++) {
      prefixSum += arr[i];
      long curr = prefixSum - target;
      if(curr == target && sum - prefixSum == target) {
        ans += map.getOrDefault(curr, 0);
      }
      map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
    }
    return ans;
  }
}
