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
    int maxi=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        int leftheight = maxHeight(root.left);
        int rightheight = maxHeight(root.right);
        maxi = Math.max(maxi,leftheight+rightheight);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxi;

        
    }

    public int maxHeight(TreeNode root) {
        if(root==null) return 0;

        return 1+ Math.max(maxHeight(root.left),maxHeight(root.right));
    }
}
