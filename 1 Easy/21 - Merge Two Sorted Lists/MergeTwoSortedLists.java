/*
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 */

/*
 * Definition for singly-linked list.
 * public class ListNode {
 * 	   int val;
 * 	   ListNode next;
 * 	   ListNode(int x) { val = x;}
 * }
 */

class ListNode {
    private int val;
    private ListNode next;

    public ListNode() {}

    public ListNode(int x) {
        val = x;
    }

    public void link(ListNode l) {
        this.next = l;
    }

    public int getValue() {
        int res = val;
        return res;
    }

    public void setNext(ListNode l) {
        this.next = l;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void add(ListNode l) {
        ListNode i = this;
        if (i.next == null) {
            i.next = l;
        } else {
            while (i.next != null) {
                i = i.next;
            }
            i.next = l;
        }
    }

    public void concat(ListNode l) {
        ListNode i = this;
        while (i.next != null) {
            i = i.next;
        }
        i.next = l;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;

        if (l1 == null && l2 != null) {
            res = l2;
            l2 = null;
            return res;
        } else if (l1 != null && l2 == null) {
            res = l1;
            l1 = null;
            return res;
        } else if (l1 == null && l2 == null) {
            return res;
        }
        if (l1.getValue() >= l2.getValue()) {
            res = l2;
            l2 = l2.getNext();
        } else {
            res = l1;
            l1 = l1.getNext();
        }
        res.setNext(null);

        while (l1 != null && l2 != null) {
            ListNode temp = null;
            if (l1.getValue() >= l2.getValue()) {
                temp = l2;
                l2 = l2.getNext();
            } else {
                temp = l1;
                l1 = l1.getNext();
            }
            temp.setNext(null);
            res.add(temp);
        }
        if (l1 == null && l2 != null) {
            res.concat(l2);
        } else if (l1 != null &&l2 == null) {
            res.concat(l1);
        }
        return res;
    }

    public void display() {
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

class MergeTwoSortedLists {

    public static void main(String args[]) {
        ListNode l1 = new ListNode(10);
        ListNode l2 = new ListNode(15);
        ListNode l3 = new ListNode();
        ListNode temp;

        // setting list l1
        temp = new ListNode(20);
        l1.add(temp);
        temp = new ListNode(30);
        l1.add(temp);

        // setting list l2
        temp = new ListNode(18);
        l2.add(temp);
        temp = new ListNode(25);
        l2.add(temp);
        temp = new ListNode(35);
        l2.add(temp);
        temp = new ListNode(45);
        l2.add(temp);

        System.out.print("[MAIN] List l1 = ");
        l1.display();
        System.out.print("[MAIN] List l2 = ");
        l2.display();

        l3 = l3.mergeTwoLists(l1, l2);
        System.out.print("[MAIN] List l3 = ");
        l3.display();

        ListNode l4 = null;
        ListNode l5 = new ListNode(27);
        ListNode l6 = new ListNode();
        l6 = l6.mergeTwoLists(l4, l5);
        System.out.print("[MAIN] List l6 = ");
        l6.display();
    }
}
