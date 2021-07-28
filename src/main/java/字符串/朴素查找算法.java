package 字符串;

/**
 * 暴利破解
 */
public class 朴素查找算法 {

    public static void main(String[] args) {
        //abcaabcab  匹配 abcab
        String s = "abcaabcab", p = "abcab";
        int cur = 0, next = 0;
        while (true) {
            if (next >= p.length()) {
                System.out.println("匹配成功" + cur);
                return;
            }
            if (s.charAt(next) == p.charAt(next - cur)) next++;
            else {
                cur++;
                next = cur;
            }
        }
    }

}
