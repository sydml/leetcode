package leetcode.editor.cn;

//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 369 👎 0

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays{
	public static void main(String[] args) {
		Solution solution = new IntersectionOfTwoArrays().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> result = new HashSet<>();
		boolean flag = false;
		if (nums2.length >= nums1.length) {
			flag = true;
			for (int i = 0; i < nums1.length; i++) {
				set.add(nums1[i]);
			}
		} else {
			for (int i = 0; i < nums2.length; i++) {
				set.add(nums2[i]);
			}
		}
		if (flag) {
			for (int i = 0; i < nums1.length; i++) {
				if (set.contains(nums1[i])) {
					result.add(nums1[i]);
				}
			}
		} else {
			for (int i = 0; i < nums2.length; i++) {
				if (set.contains(nums2[i])) {
					result.add(nums2[i]);
				}
			}
		}
		return result.stream().mapToInt(i->i).toArray();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
