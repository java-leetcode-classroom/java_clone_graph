import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    final private Solution sol = new Solution();
    static Node CreateGraph(int[][] graph) {
      int nLen = graph.length;
      Node[] temp = new Node[4];
      for (int i = 0; i < nLen; i++) {
          temp[i] = new Node(i+1);
      }
      for (int i = 0; i < nLen; i++) {
          int rLen = graph[i].length;
          for (int p = 0; p < rLen; p++) {
              Node ele = temp[graph[i][p]-1];
              temp[i].neighbors.add(ele);
          }
      }
      return temp[0];
    }
    @Test
    void cloneGraphExample1() {
        Assertions.assertEquals(CreateGraph(new int[][]{{2,4}, {1,3}, {2,4}, {1,3}}), sol.cloneGraph(CreateGraph(new int[][]{{2,4}, {1,3}, {2,4}, {1,3}})));
    }
    @Test
    void cloneGraphExample2() {
        Assertions.assertEquals(new Node(1), sol.cloneGraph(new Node(1)));
    }
    @Test
    void cloneGraphExample3() {
        Assertions.assertNull(sol.cloneGraph(null));
    }
}