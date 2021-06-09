package leetcode.editor.cn;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2807 👎 0

public class ReverseInteger{
	public static void main(String[] args) {
		Solution solution = new ReverseInteger().new Solution();

		System.out.println(solution.reverse(1534236469));

	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
		/*int result;
		if (x < 0) {
			int abs = Math.abs(x);
			String valueString = String.valueOf(abs);
			result = -getReverseInt(valueString);
		}else{
			result = getReverseInt(String.valueOf(x));
		}
		if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
			return 0;
		}else {
			return result;
		}*/
		long res = 0;
		while (x != 0) {
			int tail = x %10;
			res = res * 10 + tail;
			if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
				return 0;
			}
			x = x / 10;
		}
		return (int) res;
	}

	private int getReverseInt(String valueString) {
		int result=0;
		if (valueString.length() == 1) {
			result = Integer.parseInt(valueString);
		}else{
			char[] chars = valueString.toCharArray();
			for (int i = 0; i < chars.length/2; i++) {
				char temp = chars[i];
				chars[i] = chars[chars.length-1 - i];
				chars[chars.length-1-i] = temp;
			}
			try {
				result = Integer.parseInt(String.valueOf(chars));
			} catch (Exception e) {
				return 0;
			}
		}
		return result;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}