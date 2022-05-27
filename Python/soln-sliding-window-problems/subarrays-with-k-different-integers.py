class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        
        def window(nums, k):
            left = 0
            right = 0

            res = 0
            in_set = set()
            hash_map = collections.Counter()

            while right < len(nums):
                in_set.add(nums[right])
                hash_map[nums[right]] += 1

                while len(in_set) > k:
                    hash_map[nums[left]] -= 1
                    if hash_map[nums[left]] == 0:
                        in_set.remove(nums[left])
                    left += 1

                res += (right - left + 1)

                right += 1
            return res
    
        return window(nums, k) - window(nums, k - 1)