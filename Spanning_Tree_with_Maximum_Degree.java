import java.util.*;
public class Spanning_Tree_with_Maximum_Degree {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    graph = new ArrayList[n+1];
    for(int i = 0; i <= n; i++) {
      List<Integer> ll = new ArrayList<>();
      ll.add(i);//for u identification because after sorting there order will change so we need to identify each by there first index
      graph[i] = ll;
    }
    while(m-- > 0) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      graph[u].add(v);
      graph[v].add(u);
    }
    System.out.println(solve(n));
  }
  static List<Integer>[] graph;
  public static String solve(int n) {
    Arrays.sort(graph, (a, b)->b.size()-a.size());
    
    DSU dsu = new DSU();
    for(int i = 1; i <= n; i++) {
      dsu.create(i);
    }
    StringBuilder sb = new StringBuilder();
    for(List<Integer> ll: graph) {
      if(ll.size() <= 1) {
        continue;
      }
      int u = ll.get(0);
      for(int i = 1; i < ll.size(); i++) {
        int v = ll.get(i);
        int re1 = dsu.find(u);
        int re2 = dsu.find(v);
        if(re1 == re2) {
            // cycle
        }
        else {
          dsu.union(u, v);
          sb.append(u+" "+v).append("\n");
        }
      }
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
    }
  }
  class DSU {
    class Node {
      int val;
      int rank;
      Node parent;
    }
    private HashMap<Integer, Node> map = new HashMap<>();

    public void create(int v) {
      Node nn = new Node();
      nn.val = v;
      nn.rank = 0;
      nn.parent = nn;
      map.put(v, nn);
    }
    public int find(int v) {
      Node node =  map.get(v);
      return find(node).val;
    }
    private Node find(Node node) {
      if(node.parent == node) {
        return node;
      }
      Node nn = find(node.parent);
      node.parent = nn;
      return nn;
    }

    public void union(int v1, int v2) {
      Node node1 = map.get(v1);
      Node node2 = map.get(v2);
      Node re1 = find(node1);
      Node re2 = find(node2);
      if(re1.rank == re2.rank) {
          re1.parent = re2;
          re2.rank++;
      }
      else if(re1.rank < re2.rank) {
          re1.parent = re2;
      }
      else {
          re2.parent = re1;
      }
    }
  }
