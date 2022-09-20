package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * author: liuyuming
 * date: 2022-09-20 23:34:28
 */
//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴
// 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 447 👎 0

public class FindKClosestElements {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
// 二分搜索找到 x 的位置
            int p = left_bound(arr, x);
            // 两端都开的区间 (left, right)
            int left = p - 1, right = p;
            LinkedList<Integer> res = new LinkedList<>();
            // 扩展区间，直到区间内包含 k 个元素
            while (right - left - 1 < k) {
                if (left == -1) {
                    res.addLast(arr[right]);
                    right++;
                } else if (right == arr.length) {
                    res.addFirst(arr[left]);
                    left--;
                } else if (x - arr[left] > arr[right] - x) {
                    res.addLast(arr[right]);
                    right++;
                } else {
                    res.addFirst(arr[left]);
                    left--;
                }
            }
            return res;
        }

        // 搜索左侧边界的二分搜索
        int left_bound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            return left;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
    }
}