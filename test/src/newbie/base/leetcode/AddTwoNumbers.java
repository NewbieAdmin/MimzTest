package newbie.base.leetcode;

public class AddTwoNumbers {

    /**
     * 两数相加
     * <p>
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNum(ListNode l1, ListNode l2) {
        /*if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        boolean flag = false;
        int val;
        ListNode temp1 = l1, temp2 = l2;
        ListNode next = new ListNode(0);
        ListNode result = new ListNode(0);
        ListNode temp;
        result.next = next;
        while (null != temp1 || null != temp2) {
            if (null != temp1 && null != temp2) {
                val = temp1.val + temp2.val;
            } else if (null != temp1) {
                val = temp1.val;
            } else {
                val = temp2.val;
            }
            if (flag) {
                val++;
                flag = false;
            }
            if (val >= 10) {
                flag = true;
                val -= 10;
            }
            temp = new ListNode(val);
            next.next = temp;
            next = temp;
            if(null!=temp1){
                temp1 = temp1.next;
            }
            if (null!=temp2) {
                temp2 = temp2.next;
            }
        }
        if (flag) {
            temp = new ListNode(1);
            next.next = temp;
        }
        return result.next.next;*/

        /**
         * 官方正解
         */
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        /*ListNode temp1 = new ListNode(4);
        l1.next = temp1;
        temp1 = new ListNode(3);
        l1.next.next = temp1;*/

        ListNode l2 = new ListNode(5);
        /*ListNode temp2 = new ListNode(6);
        l2.next = temp2;
        temp2 = new ListNode(4);
        l2.next.next = temp2;*/

        ListNode listNode = addTwoNum(l1, l2);

        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}