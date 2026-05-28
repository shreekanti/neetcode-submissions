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
    public int rob(TreeNode root) {
        
        int[] pair = dfs(root);
        return Math.max(pair[0],pair[1]);
        
    }

    public int[] dfs(TreeNode root) {
        if(root==null) {
            return new int[]{0,0};
        }

        int[] leftpair = dfs(root.left);
        int[] rightpair = dfs(root.right);

        int withroot = root.val + leftpair[1] +rightpair[1];
        int withoutroot = Math.max(leftpair[0],leftpair[1]) + Math.max(rightpair[0],rightpair[1]);

        return new int[]{withroot,withoutroot};
    }
}