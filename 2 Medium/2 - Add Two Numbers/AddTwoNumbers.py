# -*- coding: utf-8 -*-

# You are given two non-empty linked lists representing two non-negative
# integers. The digits are stored in reverse order and each of their nodes
# contain a single digit. Add the two numbers and return it as a linked list.
#
# You may assume the two numbers do not contain any leading zero, except the
# number 0 itself.
#
# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    def setValue(self, x):
        self.val = x

    def getValue(self):
        return self.val

    def setNext(self, ln):
        self.next = ln

    def getNext(self):
        return self.next

    def hasNext(self):
        if self.next == None:
            return False
        else:
            return True

    def display(self):
        l = self
        print("(", end = '')
        if l.val != None:
            print(str(l.val), end = '')
            l = l.next
        while l.next != None:
            print(", " + str(l.val), end = '')
            l = l.next
        if l.val != None:
            print(", " + str(l.val), end = '')
        print(")")

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        i = l1
        j = l2
        carry = False
        tempSum = i.getValue() + j.getValue()

        if tempSum >= 10:
            carry = True
        res = ListNode((tempSum % 10) if carry else tempSum)
        prev = res

        while i.hasNext() or j.hasNext():
            if carry:
                tempSum = 1
                carry = False
            else:
                tempSum = 0
            if i.hasNext():
                i = i.getNext()
                tempSum = tempSum + i.getValue()
            if j.hasNext():
                j = j.getNext()
                tempSum = tempSum + j.getValue()
            if tempSum >= 10:
                carry = True
            tempNode = ListNode((tempSum % 10) if carry else tempSum)
            prev.setNext(tempNode)
            prev = tempNode
        if carry:
            tempNode = ListNode(1)
            prev.setNext(tempNode)
        return res

def main():
    s = Solution()
    l10 = ListNode(2)
    l11 = ListNode(4)
    l12 = ListNode(3)
    l20 = ListNode(5)
    l21 = ListNode(6)
    l22 = ListNode(4)

    l10.setNext(l11)
    l11.setNext(l12)
    l20.setNext(l21)
    l21.setNext(l22)
    l10.display()
    l20.display()
    res = s.addTwoNumbers(l10, l20)
    res.display()

if __name__ == '__main__':
    main()
