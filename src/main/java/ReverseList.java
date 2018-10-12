/*

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 */

package main.java;

public class ReverseList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);

        reverseBetween(A, 2,3);
    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {

        if (A.next == null || B == C)
            return A;

        ListNode nodeB = null;
        ListNode nodeC = null;
        ListNode prevB = null;
        ListNode prev = null;
        ListNode tmp = A;

        while (tmp != null && C>0){
            if (B == 1 && nodeB == null){
                nodeB = tmp;
                prevB = prev;
            }
            else if (C == 1 && nodeC == null){
                nodeC = tmp;
            }
            --B;
            --C;
            prev = tmp;
            tmp = tmp.next;
        }

        ListNode nodeCNext = nodeC.next;
        nodeC.next = null;
        ListNode reversed = reverseList(nodeB);
        if (prevB != null){
            prevB.next = reversed;
        }
        else{
            A = reversed;
        }
        while (reversed.next != null)
            reversed = reversed.next;

        reversed.next = nodeCNext;

        return A;
    }

    private static ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode current = A;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        A = prev;
        return A;
    }
}

class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }
