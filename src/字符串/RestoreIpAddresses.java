package 字符串;

import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-08 17:25
 * motto : everything is no in vain
 * description leetcode 93:复原 IP 地址
 */
public class RestoreIpAddresses {
    public List<String> solution(String s) {
        return null;
    }

    private void restoreIpAddressHelp(String s, int start, int index, List<String> result, StringBuilder tmpResultIndex) {
        if (index > 3) {
            return;
        }
        if (index == 3) {

        }
    }

    private boolean check(String s) {
        Integer code = Integer.parseInt(s);
        return (code > 0 && code < 256 && s.length() == code.toString().length());
    }

}
