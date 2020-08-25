import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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


    /**
     * 看下网上的
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return  null;
    }
    /**
     * 这应该是最简陋的通过方法了
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        boolean end = true;
        Integer value1 = 0;
        Integer value2 = 0;
        int jinwei = 0;
        List<ListNode> nodes = new ArrayList<>();
        do {
            if (l1 == null) {
                value1 = 0;
            } else {
                int val1 = l1.val;
                value1 = val1 ;
            }
            if (l2 == null) {
                value2 = 0 ;
            } else {
                int val2 = l2.val;
                value2 = val2;
            }

            if (null == l1 && null == l2) {
                end = false;
            } else {
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }



            //这里做每个位的相加结果
            int sum = value1  + value2;
            //加进位
            sum = sum + jinwei;
            if(sum > 9){
                jinwei = 1;
                nodes.add(new ListNode(sum-10));
                if(end == false ){
                    nodes.add(new ListNode(1));
                }
            }else {
                jinwei = 0;

                if(end == false){
                    if( sum == 0){

                    }else {
                        nodes.add(new ListNode(sum));
                    }
                }else {
                    nodes.add(new ListNode(sum));
                }

            }


        } while (end);


        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        return nodes.get(0);
    }


    public static void main(String[] args) {
        AddTwoNumber addTwoNumber = new AddTwoNumber();

        ListNode listNode = new ListNode(2);

        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
//        ListNode listNodeX = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
//        listNode2.next = listNodeX;
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(4);
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode6 = addTwoNumber.addTwoNumbers(listNode, listNode3);
        System.out.println("-");
    }


    /**
     * 原来不能用BigInteger 那只能自己做个累加咯 我吐了
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        boolean end = true;
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
            if (null == l1 && null == l2) {
                end = false;
            } else {
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }

        } while (end);
        BigInteger integer = new BigInteger(value1);
        BigInteger integer1 = new BigInteger(value2);

        BigInteger result = integer .add(integer1);
        String resultStr = result + "";


        List<ListNode> nodes = new ArrayList<>();
        for (int i = resultStr.length() - 1; i >= 0; i--) {
            nodes.add(new ListNode(Integer.valueOf(resultStr.charAt(i) + "")));
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        return nodes.get(0);
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}