package 栈;

import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-02-14 22:28
 * motto : everything is no in vain
 * description leetcode 946 验证栈序列
 */
public class ValidateStackSequences {
    private boolean solution(int[] pushed, int[] popped) {
        if (pushed == null || popped == null){
            return false;
        }
        if (pushed.length != popped.length){
            return false;
        }
        int length = pushed.length;
        Stack<Integer> stackData = new Stack<>();
        int pushIndex = 0, popIndex = 0;
        while (popIndex < length) {
            while (stackData.empty() || stackData.peek() != popped[popIndex]) {
                if (pushIndex >= length) {
                    //表示压栈数组已经到末端了也就是越界了
                    break;
                }
                stackData.push(pushed[pushIndex]);
                pushIndex++;
            }
            //当压栈数组已经到末尾的时候，有可能这个时候栈顶的数字并不是弹出数组所要的数字，这个时候就表明这个弹出数组不符合情况
            if (stackData.peek() != popped[popIndex]){
                return false;
            }
            stackData.pop();
            popIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        System.out.println(new ValidateStackSequences().solution(pushed, popped));
    }
}
