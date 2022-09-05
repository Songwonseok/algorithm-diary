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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        
        if(list2 == null) {
            return list1;
        }
        
        ListNode lNode = list1;
        ListNode rNode = list2;
        
        ListNode head = null;
        
        if(lNode.val <= rNode.val) {
            head = new ListNode(lNode.val);
            lNode = lNode.next;
        }else {
            head = new ListNode(rNode.val);
            rNode = rNode.next;
        }
        
        
        ListNode curr = head;
        
        while(lNode != null || rNode != null){     
            ListNode next = null;
            
            if(rNode == null) {
                next = new ListNode(lNode.val);
                lNode = lNode.next;
            }else if(lNode == null) {
                next = new ListNode(rNode.val);
                rNode = rNode.next;
            }else if(lNode.val <= rNode.val) {
                next = new ListNode(lNode.val);
                lNode = lNode.next;
            }else {
                next = new ListNode(rNode.val);
                rNode = rNode.next;
            }
            
            curr.next = next;
            curr = curr.next;
        }
        
        
        return head;
            
    }
    

}