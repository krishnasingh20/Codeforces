import java.util.*;
public class Ehab_Fails_to_Be_Thanos {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[2*n];
    for(int i = 0; i < 2*n; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    if(arr[0] == arr[2*n - 1]) {
      System.out.println(-1);
      return;
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 2*n; i++) {
      sb.append(arr[i]+" ");
    }
    System.out.println(sb.toString());
  }
}
