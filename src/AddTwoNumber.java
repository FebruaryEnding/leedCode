import java.math.BigDecimal;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean end = false;
        String value1 = "";
        String value2 = "";
        do {
            if (l1 == null) {
                value1 = 0 + value1;
            } else {
                int val1 = l1.val;
                value1 = val1 + value1;
            }
            if (l2 == null) {
                value2 = 0 + value2;
            } else {
                int val2 = l2.val;
                value2 = val2 + value2;
            }
            if (l1.next != null || l2.next != null) {

            } else {
                end = true;
            }

        } while (end);
        Integer integer = Integer.valueOf(value1);
        Integer integer1 = Integer.valueOf(value2);
        int result = integer + integer1;

        return null;
    }


    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0123");
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}