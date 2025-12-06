import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner();
    int T = sc.nextInt();
    while(T-- > 0) {
      char[] s = (sc.next()).toCharArray();
      char[] t= (sc.next()).toCharArray();
      System.out.println(solve(s, t));
    }
  }
  public static String solve(char[] s, char[] t) {
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];
    int[][] prefix = new int[s.length][26];
    for(int i = s.length - 1; i >= 0; i--) {
      freq1[s[i]-'a']++;
      prefix[i][s[i]-'a']++;
      if(i == s.length - 1) {
        continue;
      }
      for(int j = 0; j < 26; j++) {
        prefix[i][j] += prefix[i+1][j];
      }
    }
    for(int i = 0; i < t.length; i++) {
      freq2[t[i]-'a']++;
    }
    for(int i = 0; i < 26; i++) {
      if(freq1[i] > freq2[i]) {
        return "Impossible";
      }
      freq2[i] -= freq1[i];
    }
    StringBuilder str = new StringBuilder();
    for(int i = 0; i < s.length; i++) {
      char c = s[i];
      for(int j = 0; j < c-'a'; j++) {
        int x = freq2[j];
        while(x > 0) {
          str.append((char)(j+'a'));
          x--;
        }
        freq2[j] = 0;
      }
      str.append(c);
      if(freq2[c-'a'] > 0) {
        boolean flag = true;
        for(int j = 0; j < c-'a'; j++) {
          if(prefix[i][j] > 0) {
            flag = false;
            break;
          }
        }
        if(flag) {
          int x = freq2[c-'a'];
          freq2[c-'a'] = 0;
          while(x > 0) {
            str.append(c);
            x--;
          }
        }
      }
    }
    for(int i = 0; i < 26; i++) {
      if(freq2[i] > 0) {
        int x = freq2[i];
        while(x > 0) {
          str.append((char)(i+'a'));
          x--;
        }
      }
    }
    return str.toString();
  }
}
