package 链表;

import java.util.*;

/**
 * @author WilderGao
 * time 2018-10-15 11:02
 * motto : everything is no in vain
 * description 判断链表是否有环
 */
public class HasCycle {
    /**
     * 判断链表是否有环
     *
     * @param head 链表头节点
     * @return true代表存在，false代表不存在
     */
    public boolean hasCycle(ListNode head) {
        if (head != null) {
            // 用两个指针分别指向头节点
            ListNode indexFirst = head;
            ListNode indexSecond = head;
            if (indexFirst.next != null) {
                if (head.next.next != null) {
                    // 第一个节点每次向后移动一个单位
                    indexFirst = indexFirst.next;
                    //第二个节点每次向后移动两个单位
                    indexSecond = indexSecond.next.next;
                    while (indexSecond != null) {
                        indexSecond = indexSecond.next;
                        //若指向的链表有环，返回该节点
                        if (indexFirst == indexSecond)
                            return true;
                        indexFirst = indexFirst.next;
                        if (indexSecond != null)
                            indexSecond = indexSecond.next;

                    }
                }
            }
        }
        return false;
    }

    /**
     * 链表中是否存在环，如果存在，找到这个节点并返回
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == null || slow.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        String s = "4 /order/pnrList/pnrPriceList /order/pnrList/pnrPriceList/price /order/pnrList/pnrPriceList/price /order/pnrList/pnrPriceList /order/pnrList/pnrPriceList";
        String[] contents = s.split(" ");
        Map<Integer, Integer> sameMap = new HashMap<>(contents.length);
        for (int i = 1; i<contents.length; i++){
            sameMap.put(i, 0);
        }
        for (int i = 1; i < contents.length; i++) {
            for (int j = 0; j<=i; j++){
                if (i != j && contents[i].equals(contents[j])){
                    int value = sameMap.get(i);
                    sameMap.put(i, ++value);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : sameMap.entrySet()) {
            int key = entry.getKey();
            int values = entry.getValue();
            StringBuilder reb = new StringBuilder("1");
            int l = contents[key].split("/").length-1;
            int i = 2;
            while (i < l){
                reb.append(1+values);
                i++;
            }
            if (l > 1) {
                reb.append("1");
            }
            System.out.print(reb.toString()+" ");
        }
    }
}

