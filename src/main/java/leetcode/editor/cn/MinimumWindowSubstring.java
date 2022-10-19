package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * author: liuyuming
 * date: 2022-10-19 17:25:12
 */
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2208 👎 0

public class MinimumWindowSubstring{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow( String s, String t ) {
        String res = "";
        if ( t.length() > s.length() ) {
            return res;
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for ( int i = 0; i < t.length(); i++ ) {
            char ch = t.charAt( i );
            need.put( ch, need.getOrDefault( ch, 0 ) + 1 );
        }
        int l = 0;
        int r = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while ( r < s.length() ) {
            char ch = s.charAt( r );
            r++;
            if ( need.containsKey( ch ) ) {
                window.put( ch, window.getOrDefault( ch, 0 ) + 1 );
                if ( window.get( ch ).equals( need.get( ch ) ) ) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while ( valid == need.size() ) {
                // 在这里更新最小覆盖子串
                if ( r - l < len ) {
                    start = l;
                    len = r - l;
                }
                // d 是将移出窗口的字符
                char d = s.charAt( l );
                // 左移窗口
                l++;
                // 进行窗口内数据的一系列更新
                if ( need.containsKey( d ) ) {
                    if ( window.get( d ).equals( need.get( d ) ) ) {
                        valid--;
                    }
                    window.put( d, window.get( d ) - 1 );
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring( start, start+len );
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
		Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("ADOBECODEBANC", "ABC");
	}
}
