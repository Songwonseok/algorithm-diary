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
    public ListNode middleNode(ListNode head) {
        ListNode[] array = new ListNode[101];
        
        
        int count = 0;
        ListNode node = head;
        
        while(node != null) {
            count++;
            array[count] = node;
            node = node.next;
        }
        
        
        return array[count / 2 + 1];
        
    }
}