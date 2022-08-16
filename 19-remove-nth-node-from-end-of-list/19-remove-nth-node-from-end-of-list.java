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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] array = new ListNode[30];
        int index = 0;
        ListNode node = head;
        
        while(node != null) {     
            array[index] = node;
            node = node.next;            
            index++;
        }
        
        
        if(index == 1) {
            return null;
        }else if(index == n) {
            head = array[index - n +1];
        }else {
            array[index - n - 1].next = array[index - n].next;
        }
        
        
        return head;
        
    }
}