# Python program to demonstrate
# stack implementation using a list as array

class Stack:
    def __init__(self):
        self.st=[]

    def __str__(self):
        return ' '.join(str(n) for n in self.st)

    # push operation-insertion in O(1)
    # pushing data at the top of the stack 
    # is same as appending data at the end of the list
    def Push(self,x):
        self.st.append(x)
    
    # popping data from the top of the stack in O(1)
    # using pop function of list to delete the data from top end 
    def Pop(self):
        return self.st.pop()

    # getting the top element from stack in O(1)
    def Peek(self):
        return self.st[-1]

    def IsEmpty(self):
        return len(self.st)==0

# list(array) as stack
stack=Stack()

print("Stack is Empty" if stack.IsEmpty() else "Stack is not Empty")
stack.Push(5)
stack.Push(8)
stack.Push(9)
print(stack)

print("Data deleted-> "+ str(stack.Pop()))
print(stack)
print("Data deleted-> "+ str(stack.Pop()))
print(stack)

stack.Push(15)
print(stack)
stack.Push(8)
print(stack)
stack.Push(7)
print(stack)
stack.Push(2)
print(stack)

print("Stack is Empty" if stack.IsEmpty() else "Stack is not Empty")

# print("Top by reverse indexing->",stack[-1])
# print("Top by size-1 index->",stack[len(stack)-1])
# print("Deleted data->",stack.pop())
# print("Top by reverse indexing->",stack[-1])
# print("Top by size-1 index->",stack[len(stack)-1])
print("Top element of stack->",str(stack.Peek()))





