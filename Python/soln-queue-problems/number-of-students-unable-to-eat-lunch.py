# https://leetcode.com/problems/    1

class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        students = collections.deque(students)
        sandwhiches = collections.deque(sandwiches)
        skips = 0ss
        while skips < len(students):
            if students[0] == sandwhiches[0]:
                sandwhiches.popleft()
                skips = 0
            else:
                students.append(students[0])
                skips += 1
            students.popleft()
        return len(students)