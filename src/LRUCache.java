import java.util.*;

/**
 * @author WilderGao
 * time 2019-10-03 21:20
 * motto : everything is no in vain
 * description leetcode 146: LRU缓存机制
 */
public class LRUCache {
    private List<Node> nodeList;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        nodeList = new LinkedList<>();
        map = new HashMap<>(16);
        this.capacity = capacity;
    }

    public int get(int key) {
        int result = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            //从当前位置移除并添加到链表头部
            nodeList.remove(node);
            nodeList.add(0, node);
            result = node.value;
        }
        return result;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //之前存在的，不需要删掉
            Node node = map.get(key);
            nodeList.remove(node);
            node.value = value;
            nodeList.add(0, node);
            map.put(key, node);
            return;
        }

        if (nodeList.size() == capacity) {
            //超过指定大小需要移除链表最末尾的值
            Node removeNode = nodeList.remove(nodeList.size() - 1);
            map.remove(removeNode.key);
        }
        Node newNode = new Node(key, value);
        nodeList.add(0, newNode);
        map.put(key, newNode);
    }

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        //["LRUCache","put","put","put","put","get","get"]
        //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
    }
}
