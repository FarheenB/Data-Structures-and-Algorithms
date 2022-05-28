class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums or not k or k < 0:
            return None
        min_heap = []
        for i in nums:
            heapq.heappush(min_heap,i)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        return heapq.heappop(min_heap)