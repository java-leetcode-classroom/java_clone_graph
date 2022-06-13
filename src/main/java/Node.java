import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return false;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return val == node.val && neighbors.size() == node.neighbors.size();
    }


}
