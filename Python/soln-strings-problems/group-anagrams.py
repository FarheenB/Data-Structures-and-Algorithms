class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groupMap={}
        for word in strs:
            sortedWord=''.join(sorted(word))
            if sortedWord not in groupMap:
                groupMap[sortedWord]=[word]
            else:
                groupMap[sortedWord].append(word)
            
        return groupMap.values()