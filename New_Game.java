import java.util.*;
public class New_Game {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    New_Game obj = new New_Game();
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(obj.solve(n, k, arr));
    }
    sc.close();
  }
  public int solve(int n, int k, int[] arr) {
    Arrays.sort(arr);
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int a: arr) {
      map.put(a, map.getOrDefault(a, 0)+1);
    }
    int j = 1;
    int i = 1;
    while(i < n) {
      if(arr[i] != arr[j-1]) {
        arr[j] = arr[i];
        j++;
      }
      i++;
    }
    int start = 0;
    int curr = map.get(arr[0]);
    int ans = curr;
    int cnt = 1;
    for(i = 1; i < j; i++) {
      if(arr[i]-1 != arr[i-1]) {
        curr = map.get(arr[i]);
        start = i;
        cnt = 1;
      }
      else if(cnt+1 > k) {
        curr -= map.get(arr[start]);
        curr += map.get(arr[i]);
        start++;
      }
      else {
        cnt++;
        curr += map.get(arr[i]);
      }
      ans = Math.max(ans, curr);
    }
    return ans;
  }
}
