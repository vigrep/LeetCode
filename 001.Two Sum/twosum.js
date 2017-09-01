/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

//Approach #1 (Brute Force)
var twoSum_1 = function(nums, target) {
	for (var i = 0; i < nums.length; i++) {
		for (var j = i + 1; j < nums.length; j++) {
			if (target - nums[i] == nums[j])
				return [i, j];
		}
	}
	return [-1, -1];
}

//Approach #2 (Two-pass Hash Table)
var twoSum_2 = function(nums, target) {
	var map = new Map();
	for (var i = 0; i < nums.length; i++) {
		map.set(nums[i], i);
	}
	var complement;
	for (var i = 0; i < nums.length; i++) {
		complement = target - nums[i];
		if (map.has(complement) && map.get(complement) != i)
			return [i, map.get(complement)];
	}
	return [-1, -1];
}

//Approach #3 (One-pass Hash Table)
var twoSum_3 = function(nums, target) {
	var map = new Map();
	var complement;
	for (var i = 0; i < nums.length; i++) {
		complement = target - nums[i];
		if (map.has(complement))
			return [map.get(complement), i];
		map.set(nums[i], i);
	}
	return [-1, -1];
}

//test
var input = [3, 2, 4];
var target = 6;
console.log("input is [%d, %d, %d], target is: %d", input[0], input[1], input[2], target);

console.log("output is:");
var output = twoSum_1(input, target);
console.log("Approach #1: [%d, %d]", output[0], output[1]);

output = twoSum_2(input, target);
console.log("Approach #2: [%d, %d]", output[0], output[1]);

output = twoSum_3(input, target);
console.log("Approach #3: [%d, %d]", output[0], output[1]);
