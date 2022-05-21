# https://leetcode.com/problems/number-of-students-unable-to-eat-lunch

class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        students = collections.deque(students)
        sandwhiches = collections.deque(sandwiches)
        skips = 0
        while skips < len(students):
            if students[0] == sandwhiches[0]:
                sandwhiches.popleft()
                skips = 0
            else:
                students.append(students[0])
                skips += 1
            students.popleft()
        return len(students)