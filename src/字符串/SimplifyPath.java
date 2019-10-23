package 字符串;

import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-18 21:53
 * motto : everything is no in vain
 * description 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级
 * （指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）
 * 不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 */
public class SimplifyPath {
    /**
     * 还是没能通过所有用例，但思路应该没错，用栈来处理
     * @param path
     * @return
     */
    public String solution(String path) {
        String pathReplace = path.replaceAll("//", "/");
        if (!pathReplace.contains(".")) {
            if (pathReplace.length() > 1 && pathReplace.charAt(pathReplace.length() - 1) == '/') {
                return pathReplace.substring(0, pathReplace.length() - 1);
            }
            return pathReplace;
        }
        Stack<Character> stack = new Stack<>();
        stack.push('/');
        for (int i = 1; i < pathReplace.length() - 1; i++) {
            if (pathReplace.charAt(i) == '.') {
                if (pathReplace.charAt(i + 1) == '.') {
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() != '/') {
                        stack.pop();
                    }
                    i++;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(pathReplace.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        if (!stack.isEmpty() && stack.peek() == '/') {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        String result = res.reverse().toString();
        if (result.equals("")){
            result = "/";
        }
        return result.replaceAll("//", "/");
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().solution("/"));
    }
}
