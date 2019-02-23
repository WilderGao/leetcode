package 链表;

/**
 * @author WilderGao
 * time 2019-02-12 22:09
 * motto : everything is no in vain
 * description leetcode 21 合并两个有序链表
 */
public class MergeTwoLists {
    private ListNode solution(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        }else if (l2 == null){
            return l1;
        }
        ListNode pMergedHead;
        if (l1.val < l2.val){
            pMergedHead = l1;
            pMergedHead.next = solution(l1.next, l2);
        }else {
            pMergedHead = l2;
            pMergedHead.next = solution(l1, l2.next);
        }
        return pMergedHead;
    }
}
