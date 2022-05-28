class Solution(object):
    def findClosestElements(self, arr, k, x):
        heap,res = [],[]
        for i in arr:
            heap.append((abs(x-i),i))
        heapq.heapify(heap)
        for _ in range(k):
            res.append(heapq.heappop(heap)[1])
        return sorted(res)