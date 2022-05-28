class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashmap = {}
        for num in nums:
            if num not in hashmap:
                hashmap[num] = 0
            hashmap[num] += 1
            
        heap = []
        for key in hashmap:
            heapq.heappush(heap, (-hashmap[key], key))
        
        res = []
        for _ in range(k):
            popped = heapq.heappop(heap)
            res.append(popped[1])
        
        return res