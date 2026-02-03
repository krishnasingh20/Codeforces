import java.util.*;
public class Virus {
  public static void main(String[] args) {
    Virus obj = new Virus();
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] arr = new int[m];
      for(int i = 0; i < m; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(obj.solve(n, m, arr));
    }
    sc.close();
  }
  private int solve(int n, int m, int[] arr) {
    Arrays.sort(arr);
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < m-1; i++) {
      int len = arr[i+1] - arr[i] - 1;
      map.put(len, map.getOrDefault(len, 0)+1);
    }
    int last = n - arr[m-1] + (arr[0] - 1);
    map.put(last, map.getOrDefault(last, 0)+1);
    int[][] arr1 = new int[map.size()][2];
    int i = 0;
    for(int key: map.keySet()) {
      arr1[i][0] = key;
      arr1[i][1] = map.get(key);
      i++;
    }
    Arrays.sort(arr1, (a, b)->b[0]-a[0]);
    int step = 0;
    int uninfected = 0;
    for(i = 0; i < arr1.length; i++) {
      int c = arr1[i][1];
      int val = arr1[i][0];
      while(c-- > 0) {
        val -= (step*2);
        if(val == 1) {
          uninfected++;
        }
        uninfected += Math.max(0, val-1);
        step += 2;
        val = arr1[i][0];
      }
    }
    return n - uninfected;
  }
}
