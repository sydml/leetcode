package leetcode.editor.cn;

import java.util.Locale;

/**
 * author: liuyuming
 * date: 2022-04-13 22:58:41
 */
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 512 👎 0

public class ValidPalindrome{
	public static void main(String[] args) {
		Solution solution = new ValidPalindrome().new Solution();
		System.out.println(solution.isPalindrome(" "));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();

		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if ((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z')) {
				sb.append(aChar);
			}
		}
		if (sb.toString().length() <=1) {
			return false;
		}

		String[] ss = sb.toString().toLowerCase().split("");
		// 双指针
		int left = 0, right = ss.length - 1;
		while (left < right) {
			if (!ss[left].equals(ss[right])){
				return false;
			}
			left++; right--;
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}