import java.util.*;
public class Kuriyama_Mirai's_Stones {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] prefixV = new long[n+1];
    long[] prefixU = new long[n+1];
    for(int i = 1; i <= n; i++) {
      prefixU[i] = sc.nextLong();
      prefixV[i] = prefixU[i] + prefixV[i-1];
    }
    Arrays.sort(prefixU);
    for(int i = 1; i <= n; i++) {
      prefixU[i] += prefixU[i-1];
    }
    StringBuilder sb = new StringBuilder();
    int m = sc.nextInt();
    while(m-- > 0) {
      int opr = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      if(opr == 1) {
        sb.append((prefixV[r]-prefixV[l-1])).append("\n");
      }
      else {
        sb.append((prefixU[r]-prefixU[l-1])).append("\n");
      }
    }
    sb.deleteCharAt(sb.length()-1);
    System.out.println(sb.toString());
    
    sc.close();
  }
}
