package 数字;

/**
 * @author WilderGao
 * time 2019-10-06 21:39
 * motto : everything is no in vain
 * description
 */
public class FindKthNumber {
    private static int currentIndex = 0;

    public static int solution(int n, int k) {
        StringBuilder result = new StringBuilder();
        int resultIndex = 0;
        for (int i = 1; i < 9; i++) {
            result.append(i);
            currentIndex++;
            resultIndex= findKthNumberHelp(n, k, result);
            if (resultIndex != -1) break;
            result.deleteCharAt(result.length()-1);
        }
        return resultIndex;
    }

    private static int findKthNumberHelp(int n, int k, StringBuilder current) {
        if (currentIndex == k) {
            return Integer.parseInt(current.toString());
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            current.append(i);
            if (Integer.parseInt(current.toString()) > n){
                current.deleteCharAt(current.length()-1);
                return -1;
            }
            currentIndex++;
            result = findKthNumberHelp(n, k, current);
            if (result != -1){
                break;
            }
            current.deleteCharAt(current.length()-1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 1));
    }
}
