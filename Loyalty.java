import java.io.*;
import java.util.*;

public class Main {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    int T = 1;
    T = sc.nextInt();
    while (T-- > 0) {
        input();
    }
  }

  public static void input() {
    int n = sc.nextInt();
    long x = sc.nextLong();
    long[] arr = new long[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextLong();
    }
    solve(n, x, arr);
  }
  public static void solve(int n, long x, long[] arr) {
    long sum = 0;
    for(long a: arr) {
      sum += a;
    }
    if(sum < x) {
      System.out.println(0);
      for(long a: arr) {
        System.out.print(a+" ");
      }
      System.out.println();
      return;
    }
    Arrays.sort(arr);
    long ans = 0;
    int i = 0;
    int j = n - 1;
    long curr = 0;
    StringBuilder str = new StringBuilder();
    while(i < j) {
      long prev = curr / x;
      if((curr + arr[i]) / x > prev && (curr + arr[j]) / x > prev) {
        str.append(arr[j]+" ");
        ans += arr[j];
        curr += arr[j];
        j--;
      }
      else if((curr+arr[i]) / x > prev) {
        ans += arr[i];
        curr += arr[i];
        str.append(arr[i]+" ");
        i++;
      }
      else if((curr+arr[j]+arr[i]) / x > prev) {
        ans += arr[j];
        curr += arr[j] + arr[i];
        str.append(arr[i]+" "+arr[j]+" ");
        j--;
        i++;
      }
      else {
        curr += arr[i];
        str.append(arr[i]+" ");
        i++;
      }
    }
    long prev = curr / x;
    if(i==j) {
      curr += arr[i];
      if(curr / x > prev) {
        ans += arr[i];
      }
      str.append(arr[i]+" ");
    }
    System.out.println(ans);
    str.deleteCharAt(str.length()-1);
    System.out.println(str.toString());
  }
}
