import java.util.*;

public class Discounts {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] price = new int[n];
      for(int i = 0; i < n; i++) {
        price[i] = sc.nextInt();
      }
      int[] voucher = new int[k];
      for(int i = 0; i < k; i++) {
        voucher[i] = sc.nextInt();
      }
      System.out.println(solve(n, k, price, voucher));
    }
    sc.close();
  }
  public static long solve(int n, int k, int[] price, int[] voucher) {
    Arrays.sort(price);
    Arrays.sort(voucher);
    long ans = 0;
    int i = n - 1;
    for(int j = 0; j < k; j++) {
      int x = voucher[j];
      while(i >= 0 && x > 0) {
        if(x-1 > 0) {
          ans += price[i];
        }
        i--;
        x--;
      }
      if(i < 0) {
        break;
      }
    }
    while(i >= 0) {
      ans += price[i];
      i--;
    }
    return ans;
  }
}
