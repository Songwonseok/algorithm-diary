/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 import java.util.*;

class Solution {
    public int pairSum(ListNode head) {
        List<Integer> values = new ArrayList();
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode reserveHalf = reserveList(slow);
        ListNode half = head;
        int max = 0;

        while(reserveHalf != null) {
            max = Math.max(max, reserveHalf.val + half.val);

            reserveHalf = reserveHalf.next;
            half = half.next;
        }


        return max;
    }

    public ListNode reserveList(ListNode head) {
        ListNode next = null;
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}