package 贪婪算法;

import java.util.*;

/**
 * @author wilder
 * @date 19-1-14 下午3:15
 * description 手动实现哈夫曼算法
 */
public class Huffman {
    /**
     * 哈夫曼算法根节点
     */
    private BinaryNode root;
    /**
     * 节点个数
     */
    private int nodeNum;

    private class BinaryNode implements Comparable<BinaryNode> {
        //这个节点代表的字符串
        String c;
        //出现的频率
        int frequent;
        BinaryNode parent;
        BinaryNode left;
        BinaryNode right;

        private BinaryNode(String c, int frequent, BinaryNode parent, BinaryNode left, BinaryNode right) {
            this.c = c;
            this.frequent = frequent;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(BinaryNode binaryNode) {
            return this.frequent - binaryNode.frequent;
        }

        /**
         * 判断是不是左节点
         *
         * @return 是返回true否则返回false
         */
        public boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        public boolean isRightChild() {
            return parent != null && parent.right == this;
        }

    }

    /**
     * 构建哈夫曼树，返回根节点
     *
     * @param binaryNodes 原先的节点森林
     * @return 根节点
     */
    private BinaryNode buildHuffman(List<BinaryNode> binaryNodes) {
        Integer index = 1;
        //按照优先级的队列
        PriorityQueue<BinaryNode> priorityQueue = new PriorityQueue<>(binaryNodes);
        while (priorityQueue.size() != 1) {
            BinaryNode left = priorityQueue.remove();
            BinaryNode right = priorityQueue.remove();
            //构建一个新的节点
            BinaryNode parent = new BinaryNode("T" + index, left.frequent + right.frequent, null, left, right);
            left.parent = parent;
            right.parent = parent;
            priorityQueue.add(parent);
            index++;
        }
        root = priorityQueue.remove();
        return root;
    }

    private List<BinaryNode> buildBinaryNodeList(Map<String, Integer> map) {
        List<BinaryNode> nodeList = new LinkedList<>();
        map.forEach((k, v) -> {
            BinaryNode binaryNode = new BinaryNode(k, v, null, null, null);
            nodeList.add(binaryNode);
        });
        //节点个数等于叶子节点个数*2-1
        nodeNum = nodeList.size() * 2 - 1;
        return nodeList;
    }


    /**
     * 构建哈夫曼编码
     *
     * @param nodes 节点集合
     * @return 哈夫曼编码
     */
    private String huffmanEncoding(List<BinaryNode> nodes) {
        StringBuilder result = new StringBuilder();
        BinaryNode currentNode;
        for (BinaryNode node : nodes) {
            currentNode = node;
            while (currentNode != root) {
                if (currentNode.isLeftChild()){
                    //是左节点
                    result.append("0");
                }else if (currentNode.isRightChild()){
                    result.append("1");
                }
                currentNode = currentNode.parent;
            }
        }
        return result.toString();
    }

    /**
     * 哈夫曼编码解码
     * @param huffmanString 哈夫曼编码
     * @return  解析结果
     */
    private Map<BinaryNode, String> huffmanDecoding(String huffmanString){
        BinaryNode currentNode = root;
        StringBuilder decodeString = new StringBuilder();
        Map<BinaryNode, String> result = new HashMap<>(16);
        for (int i = 0; i < huffmanString.length(); i++) {
            char c = huffmanString.charAt(i);
            decodeString.append(c);
            if (c == '0'){
                currentNode = currentNode.left;
            }else if (c == '1'){
                currentNode = currentNode.right;
            }

            if (currentNode.left == null && currentNode.right == null){
                //表明这个是叶子节点了
                result.put(currentNode, decodeString.toString());
                decodeString.delete(0, decodeString.length());
                currentNode = root;
            }
        }
        return result;
    }

    /**
     * 返回最快效率值
     * @param binaryNodes 节点集合
     * @return  最快效率值
     */
    private int huffmanCost(List<BinaryNode> binaryNodes){
        int cost = 0;
        int level;
        BinaryNode currentNode;
        for (BinaryNode node : binaryNodes) {
            level = 0;
            currentNode = node;
            while (currentNode != root){
                level++;
                currentNode = currentNode.parent;
            }
            //level为层数，开销为层数*频率
            cost += level* node.frequent;
        }
        return cost;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(16);
        String[] indexs = {"a","b","c","d","e"};
        Integer[] frequencies = {5,4,3,2,1};
        for (int i = 0; i < indexs.length; i++) {
            map.put(indexs[i], frequencies[i]);
        }
        Huffman huffman = new Huffman();
        List<BinaryNode> binaryNodes =huffman.buildBinaryNodeList(map);
        huffman.buildHuffman(binaryNodes);
        String encodeString = huffman.huffmanEncoding(binaryNodes);
        System.out.println("编码结果为："+encodeString);
        Map<BinaryNode, String> result = huffman.huffmanDecoding(encodeString);
        System.out.println("解码结果为：");
        result.forEach((k,v)->{
            System.out.println(k.c+":"+v);
        });
        System.out.println("通过哈夫曼编码的最低频率值为:"+huffman.huffmanCost(binaryNodes));
    }

}
