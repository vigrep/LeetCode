"""
:type nums: List[int]
:type target: int
:rtype: List[int]
"""

# Approach #1 (Brute Force)
def twoSum_1(nums, target):
    i = 0
    while i < len(nums):
        j = i + 1
        while j < len(nums):
            if target - nums[i] == nums[j]:
                return [i, j]
            j = j + 1
        i = i + 1
    return [-1, -1]

# Approach #2 (Two-pass Hash Table)
def twoSum_2(nums, target):
    map = {}
    i = 0
    while i < len(nums):
        map[nums[i]] = i
        i = i + 1  
    i = 0
    while i < len(nums):
        complement = target - nums[i]
        if complement in map and map.get(complement) != i:
            return [i, map.get(complement)]
        i = i + 1
    return [-1, -1]

# Approach #3 (One-pass Hash Table)
def twoSum_3(nums, target):
    map = {}
    for i in range(len(nums)):
        complement = target - nums[i]
        if complement in map:
            return [map.get(complement), i]
        map[nums[i]] = i
    return [-1, -1]


# test
input_nums = [3,2,4]
target = 6
print("input_nums is: [%d, %d, %d], target is: %d" % (input_nums[0], input_nums[1], input_nums[2], target))

print("output is:")
output = twoSum_1(input_nums, target)
print("Approach #1:", output)

output = twoSum_2(input_nums, target)
print("Approach #2:", output)

output = twoSum_3(input_nums, target)
print("Approach #3:", output)
