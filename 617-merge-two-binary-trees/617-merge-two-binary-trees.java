/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        }
        
        if(root2 == null) {
            return root1;
        }
        
        Queue<TreeNode[]> queue = new LinkedList();
        
        int val1 = root1 != null ? root1.val : 0;
        int val2 = root2 != null ? root2.val : 0;
        
        TreeNode merged = new TreeNode(val1 + val2);
        
        queue.add(new TreeNode[] {root1, root2, merged});
        
        while(!queue.isEmpty()) {
            TreeNode[] curr = queue.poll();
            
            TreeNode mergedLeftNode = mergeLeft(curr[0], curr[1]);
            TreeNode mergedRightNode = mergeRight(curr[0], curr[1]);
            
            
            if(mergedLeftNode != null) {
                curr[2].left = mergedLeftNode;
                TreeNode left1 = curr[0] != null ? curr[0].left : null;
                TreeNode left2 = curr[1] != null ? curr[1].left : null;
                
                queue.add(new TreeNode[] {left1, left2, mergedLeftNode});
            }
            
            if(mergedRightNode != null) {
                curr[2].right = mergedRightNode;
                TreeNode right1 = curr[0] != null ? curr[0].right : null;
                TreeNode right2 = curr[1] != null ? curr[1].right : null;
                
                queue.add(new TreeNode[] {right1, right2, mergedRightNode});
            }
            
        }
        
        return merged;
        
    }
    
    
    public TreeNode mergeLeft(TreeNode node1, TreeNode node2) {
        TreeNode left1 = node1 != null ? node1.left : null;
        TreeNode left2 = node2 != null ? node2.left : null;
        
        if(left1 == null && left2 == null) {
            return null;
        }
        
        int val1 = left1 != null ? left1.val : 0;
        int val2 = left2 != null ? left2.val : 0;
        
        
        return new TreeNode(val1 + val2);
    }
    
    public TreeNode mergeRight(TreeNode node1, TreeNode node2) {
        TreeNode right1 = node1 != null ? node1.right : null;
        TreeNode right2 = node2 != null ? node2.right : null;
        
        if(right1 == null && right2 == null) {
            return null;
        }
        
        int val1 = right1 != null ? right1.val : 0;
        int val2 = right2 != null ? right2.val : 0;
        
        
        return new TreeNode(val1 + val2);
    }
    
}