/*
 * 17/09/05 14:03:13 
 *
 *
 */

public class Solution {

	/* 
	 * Approach #1 (Brute Force)
	 *
	 * 遍历所有的子串，判断是否有重复的字符
	 * 出现重复字符时，如果上一次记录的max比当前子串的长度(j-i)小,则max = j - i
	 */
	
	public int lengthOfLongestSubstring_1(String s) {
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.substring(i, j).contains(String.valueOf(s.charAt(j)))) {
					if (max < j - i)
						max = j - i;
                    break;
				}
            }
        }
        return max;
	}

	/*
	 * Approach #2
	 */
	public int lengthOfLongestSubstring_2(String s) {
		int max = 1;
		return max;
	}

	//Test
	public static void main(String args[]) {
		String input = "abcabcbb";

		Solution solution = new Solution();
		int length = solution.lengthOfLongestSubstring_1(input);
		System.out.printf("input is: %s\n", input);
		System.out.printf("%d\n", length);
	}

}
