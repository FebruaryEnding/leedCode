import java.util.HashMap;

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
     * 340 ms
     * , 在所有 Java 提交中击败了
     * 5.73%
     * 的用户
     * 内存消耗：
     * 40.7 MB
     * , 在所有 Java 提交中击败了
     * 6.37%
     * 的用户
     * <p>
     * 好像不太行 看来其他思路更好啊
     * 我这个其实算是暴力了
     * 其实最开始是按着那个滑动窗口的思路写着的 但是没有想到把最左边去掉就行
     *
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
                    i = startIndex + currentStartIndex + 1;
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

    /**
     * 滑动窗口实现
     *执行用时：
     7 ms
     , 在所有 Java 提交中击败了
     83.13%
     的用户
     内存消耗：
     39.9 MB
     , 在所有 Java 提交中击败了
     64.29%
     的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if (null != s && s.length() > 0) {

            int startIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    int chongfuIndex = map.get(c);
                    if(chongfuIndex < startIndex){

                    }else {
                        startIndex =  chongfuIndex + 1;
                    }
                }
                map.put(c, i);
                int max = i - startIndex + 1;
                if (max > result) {
                    result = max;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubString subString = new LengthOfLongestSubString();
        String a1 = "pwwkew";//3
        System.out.println(subString.lengthOfLongestSubstring2(a1));
        String a2 = "bbbbb";//1
        System.out.println(subString.lengthOfLongestSubstring2(a2));
        String a3 = "dvdf";//3
        System.out.println(subString.lengthOfLongestSubstring2(a3));
        String a4 = "tmmzuxt";//5
        System.out.println(subString.lengthOfLongestSubstring2(a4));
        String a5 = "bbtablud";//6
        System.out.println(subString.lengthOfLongestSubstring2(a5));

    }
}
