/*
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * Input:  (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: (7 -> 0 -> 8)
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {val = x;}
 * }
 */

class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void setValue(int x) {
        val = x;
    }

    public int getValue() {
        return val;
    }

    public void Link(ListNode l) {
        next = l;
    }

    public ListNode getNext() {
        return next;
    }

    public boolean hasNext() {
        return (this.next == null ? false : true);
    }

    public void display(){
        ListNode i = next;

        System.out.print(val);
        if (i != null) {
            System.out.print(" -> ");
            i.display();
        } else {
            System.out.println();
        }
    }
}

class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        boolean carry = false;
        int tempSum = i.getValue() + j.getValue();

        if (tempSum >= 10) {
            carry = true;
        }
        ListNode res = new ListNode(carry ? (tempSum % 10) : tempSum);
        ListNode prev = res;

        while (i.hasNext() || j.hasNext()) {
            if (carry) {
                tempSum = 1;
                carry = false;
            } else {
                tempSum = 0;
            }
            if (i.hasNext()) {
                i = i.getNext();
                tempSum = tempSum + i.getValue();
            }
            if (j.hasNext()) {
                j = j.getNext();
                tempSum = tempSum + j.getValue();
            }
            if (tempSum >= 10) {
                carry = true;
            }
            ListNode n = new ListNode(carry ? (tempSum % 10) : tempSum);
            prev.Link(n);
            prev = n;
        }
        if (carry) {
            ListNode n = new ListNode(1);
            prev.Link(n);
        }
        return res;
    }

    public static void main (String[] args) {
        ListNode l10 = new ListNode(5);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        ListNode l20 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        ListNode l3 = null;

        // setting up list
        l10.Link(l11);
        l11.Link(l12);

        // setting up list
        l20.Link(l21);
        l21.Link(l22);

        l10.display();
        l20.display();

        l3 = addTwoNumbers(l10, l20);
        l3.display();
    }
}
