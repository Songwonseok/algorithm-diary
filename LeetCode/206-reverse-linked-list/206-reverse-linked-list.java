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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack();
        
        while(head != null) {
            stack.push(head);
            head = head.next;
        }
        
        
        ListNode start = new ListNode(-1);
        ListNode curr = start;
        
        while(!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
            curr.next = null;
        }
        
        return start.next;
    }
}