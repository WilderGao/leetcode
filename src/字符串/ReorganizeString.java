package 字符串;

import java.util.*;

/**
 * @author WilderGao
 * time 2019-10-02 16:48
 * motto : everything is no in vain
 * description leetcode 767：重构字符串
 */
public class ReorganizeString {
    public static String solution(String s) {
        StringBuilder resultBuilder = new StringBuilder();
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (!charMap.containsKey(s.charAt(i))) {
                charMap.put(s.charAt(i), 1);
            } else {
                Integer times = charMap.get(s.charAt(i));
                charMap.put(s.charAt(i), ++times);
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            queue.add(new Node(entry.getValue(), entry.getKey()));
        }
        if (queue.isEmpty() || queue.peek().times > (length+1) >> 1){
            return resultBuilder.toString();
        }

        //每次取出次数最多的两个字符，为什么是两个呢?如果是一个下一次就还可能当前字符是最大的，两个可以达到相邻的效果
        while (queue.size() >= 2) {
            Node nodeFirst = queue.poll();
            Node nodeSecond = queue.poll();

            resultBuilder.append(nodeFirst.c).append(nodeSecond.c);
            if (--nodeFirst.times > 0) {
                queue.add(nodeFirst);
            }
            if (--nodeSecond.times > 0) {
                queue.add(nodeSecond);
            }
        }
        //可能队列里面剩下一个，或者没有了
        if (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.times > 1) return "";
            resultBuilder.append(node.c);
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "aaab";
        System.out.println(solution(s));

    }
}

class Node implements Comparable<Node> {
    int times;
    char c;

    Node(int times, char c) {
        this.times = times;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return o.times - this.times;
    }
}
