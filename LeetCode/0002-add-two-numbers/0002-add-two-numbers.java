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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;

        ListNode curr = null;
        int acc = 0;

        while(l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;

            int sum = (num1 + num2 + acc);
            acc = sum / 10;
            sum %= 10;


            if(head == null) {
                head = new ListNode(sum);
                curr = head;
            }else {
                curr.next = new ListNode(sum);
                curr = curr.next;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if(acc > 0) {
            curr.next = new ListNode(acc);
        }

        return head;
    }
}