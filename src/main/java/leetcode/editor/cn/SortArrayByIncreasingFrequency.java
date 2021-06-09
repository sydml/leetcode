package leetcode.editor.cn;

//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
//
// 请你返回排序后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,2,2,3]
//输出：[3,1,1,2,2,2]
//解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,3,1,3,2]
//输出：[1,3,3,2,2]
//解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
// 
//
// 示例 3： 
//
// 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
//输出：[5,-1,4,4,-6,-6,1,1,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
// Related Topics 排序 数组 
// 👍 22 👎 0

import java.util.*;
import java.util.stream.Collectors;

public class SortArrayByIncreasingFrequency{
	public static void main(String[] args) {
		Solution solution = new SortArrayByIncreasingFrequency().new Solution();
		solution.frequencySort(new int[]{1, 1, 2, 2, 2, 3});
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] frequencySort(int[] nums) {
			HashMap<Integer,Integer> map=new HashMap<>();
			for(int num:nums){
				map.put(num,map.getOrDefault(num,0)+1);
			}
			ArrayList<Map.Entry<Integer,Integer>> arrayList=new ArrayList<>(map.entrySet());
			arrayList.sort((o1, o2) -> o1.getValue().equals(o2.getValue()) ? (o2.getKey().compareTo(o1.getKey())) : (o1.getValue().compareTo(o2.getValue())));

			int[] res=new int[nums.length];
			int z=0;
			for(int i=0;i<arrayList.size();i++){
				for(int j=0;j<arrayList.get(i).getValue();j++){
					res[z++]=arrayList.get(i).getKey();
				}
			}
			return res;
		}
    }
//leetcode submit region end(Prohibit modification and deletion)

}
