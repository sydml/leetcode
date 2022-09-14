package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * author: liuyuming
 * date: 2022-09-14 23:25:57
 */
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
//
// Related Topics 栈 递归 链表 双指针 👍 331 👎 0

public class CongWeiDaoTouDaYinLianBiaoLcof{
	public static void main(String[] args) {
		Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
		ListNode listNode = new ListNode(1);
		listNode.next=new ListNode(2);
		listNode.next.next = new ListNode(3);
		solution.reversePrint(listNode);
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {

		List<Integer> arr = new ArrayList<>();
		reverse(head, arr);
		int[] result = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			result[i] = arr.get(i);
		}
		return result;

	}

	void reverse(ListNode head,List<Integer> arr){
		if (head == null) {
			return;
		}
		reverse(head.next,arr);
		arr.add(head.val);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}