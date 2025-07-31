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
        
        ListNode curr = head;

        while(curr != null) {
            values.add(curr.val);

            curr = curr.next;
        }

        int left = 0;
        int right = values.size() - 1;

        int max = 0;

        while(left < right) {
            max = Math.max(values.get(left) + values.get(right), max);

            left++;
            right--;
        }

        return max;
    }
}