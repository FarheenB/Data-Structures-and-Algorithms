# Python program to demonstrate
# stack implementation using a linked list.
# node class
 
class Node(object):
    def __init__(self,data):
        self.data=data
        self.next=None
 
class Stack:
    def __init__(self):
        self.head=None
        self.size=0
    
    def __str__(self):
        temp=self.head
        result=''
        while temp is not None:
            result+=str(temp.data)+'->'
            temp=temp.next
        return result
 
    def push(self,x):
        # insert at begin
        newNode=Node(x)
        if self.head is None:
            self.head=newNode
            return
        newNode.next=self.head
        self.head=newNode
        self.size+=1
 
    def pop(self):
        # delete at begin
        if self.head is None:
            print('Stack is Empty!!')
            return -1
        toDelete=self.head.data
        self.head=self.head.next   
        self.size-=1
        return toDelete
 
    def isEmpty(self):
        return self.size==0
 
    def peek(self):
        if self.head is None:
            print("Stack is Empty!!")
            return -1
        return self.head.data
 
stack=Stack()
print(stack.isEmpty())
stack.push(5)
stack.push(2)
stack.push(3)
stack.push(8)
print(stack)
 
print("Data deleted: ",stack.pop())
print(stack)
stack.push(10)
stack.push(11)
print(stack)
print("Data deleted: ",stack.pop())
print(stack)
print(stack.isEmpty())
print("Top of stack ",stack.peek())