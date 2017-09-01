import java.util.*;

public class TwoSum {

	public static void main(String args[]) {
		//Test
		int[] input = new int[]{3,2,4};
		int target = 6;

		System.out.printf("input: [%d, %d, %d], target: %d\n", input[0], input[1], input[2], target);
		System.out.printf("output: \n");

		int[] output = twoSum_1(input, target);
		System.out.printf("Approach #1: [%d, %d]\n", output[0], output[1]);

		output = twoSum_2(input, target);
		System.out.printf("Approach #2: [%d, %d]\n", output[0], output[1]);

		output = twoSum_3(input, target);
		System.out.printf("Approach #3: [%d, %d]\n", output[0], output[1]);

	}

	//Approach #1 (Brute Force)
	public static int[] twoSum_1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[]{i, j};
			}
		}
		return new int[]{-1, -1};
	}

	//Approach #2 (Two-pass Hash Table)
	public static int[] twoSum_2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int complement;
		for (int i = 0; i < nums.length; i++) {
			complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i)
				return new int[]{i, map.get(complement)};
		}
		return new int[]{-1, -1};
	}

	//Approach #3 (one-pass Hash Table)
	public static int[] twoSum_3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int complement;
		for (int i = 0; i < nums.length; i++) {
			complement = target - nums[i];
			if (map.containsKey(complement))
				return new int[]{map.get(complement), i};
			map.put(nums[i], i);
		}
		return new int[]{-1, -1};
	}

}
