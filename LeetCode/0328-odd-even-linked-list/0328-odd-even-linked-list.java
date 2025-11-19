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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode even = null;

        ListNode evenHead = null;

        while(odd != null && odd.next != null) {
            even = odd.next;

            if(evenHead == null) {
                evenHead = even;
            }

            if(odd.next.next == null) {
                break;
            }

            odd.next = odd.next.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        if(odd != null) {
            odd.next = evenHead;
        }
        

        return head;
    }
}