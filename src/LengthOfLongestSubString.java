import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class LengthOfLongestSubString {

    /**
     * 行用时：
     340 ms
     , 在所有 Java 提交中击败了
     5.73%
     的用户
     内存消耗：
     40.7 MB
     , 在所有 Java 提交中击败了
     6.37%
     的用户

     好像不太行 看来其他思路更好啊
     我这个其实算是暴力了

     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (null != s && s.length() > 0) {
            String subStr = "";
            int startIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                if (subStr.indexOf(s.charAt(i)) != -1) {
                    int currentStartIndex = subStr.indexOf(s.charAt(i));
                    i = startIndex + currentStartIndex+1;
                    startIndex = i;
                    subStr = "";
                }
                subStr = subStr + s.charAt(i);
                if (subStr.length() > result) {
                    result = subStr.length();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubString subString = new LengthOfLongestSubString();
        String a1 = "abcabcbb";
        System.out.println(subString.lengthOfLongestSubstring(a1));
        String a2 = "bbbbb";
        System.out.println(subString.lengthOfLongestSubstring(a2));
        String a3 = "dvdf";
        System.out.println(subString.lengthOfLongestSubstring(a3));
    }
}
