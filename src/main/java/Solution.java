import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return bfsCopy(node);
    }
    public Node bfsCopy(Node node) {
        HashMap<Integer, Node> visit = new HashMap<>();
        HashMap<Integer, Node> created = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node result = null;
        while (queue.size() > 0) {
            Node top = queue.poll();
            visit.put(top.val, top);
            Node cur;
            if (created.containsKey(top.val)) {
                cur = created.get(top.val);
            } else {
                cur = new Node(top.val);
                created.put(cur.val, cur);
            }
            if (cur.val == 1) {
                result = cur;
            }
            if (top.neighbors.size() > 0 && cur.neighbors.size() == 0) {
                for (Node nei : top.neighbors) {
                    Node newNode;
                    if (created.containsKey(nei.val)) {
                        newNode = created.get(nei.val);
                    } else {
                        newNode = new Node(nei.val);
                        created.put(nei.val, newNode);
                    }
                    cur.neighbors.add(newNode);
                    if (!visit.containsKey(nei.val)) {
                        queue.add(nei);
                    }
                }
            }
        }
        return result;
    }
}
