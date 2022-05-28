class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
     
        def window(nums, k):
            i,j=0,0
            count=0

            count_dict={}

            while j<len(nums):
                if nums[j] not in count_dict:
                    count_dict[nums[j]]=0
                count_dict[nums[j]]+=1

                while(len(count_dict))>k:
                    count_dict[nums[i]]-=1

                    if count_dict[nums[i]]==0:
                        count_dict.pop(nums[i],None)
                    i+=1

                count+=j-i+1
                j+=1

            return count
        
        return window(nums,k)-window(nums,k-1)
            