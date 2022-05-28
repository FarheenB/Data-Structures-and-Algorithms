class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        heap = [(nums1[i]+nums2[0], (i, 0)) for i in range(len(nums1)) ]        
        heapq.heapify(heap)
        ans = []

        while k>0 and len(heap)>0:
            t = heapq.heappop(heap)            
            ti, tj = t[1][0], t[1][1]
            ans.append([nums1[ti], nums2[tj]])
            if tj<len(nums2)-1:
                heapq.heappush(heap, (nums1[ti]+nums2[tj+1], (ti,tj+1)))
            k-=1
        return ans