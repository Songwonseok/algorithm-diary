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
        ListNode[] array = new ListNode[100];
        
        
        int count = 0;
        ListNode node = head;
        
        while(node != null) {
            array[count] = node;
            node = node.next;
            count++;
        }
        
        
        return array[count / 2];
        
    }
}