package leetcode.editor.cn;

/**
 * author: liuyuming
 * date: 2022-09-16 22:37:41
 */
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics递归 | 链表 | 数学 
//
// 👍 8651, 👎 0 
//
//
//
//

public class AddTwoNumbers {
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1, p2 = l2;
            ListNode dumpy = new ListNode(-1);
            ListNode p = dumpy;
            int carry = 0;
            while (p1 != null || p2 != null || carry > 0) {
                int val = carry;
                if (p1 != null) {
                    val += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    val += p2.val;
                    p2 = p2.next;
                }
                carry = val / 10;
                val = val % 10;
                p.next = new ListNode(val);
                p = p.next;
            }
            return dumpy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }
}