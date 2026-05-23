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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] dia = new int[1];
        findmax(root,dia);
        return dia[0];
    }

    public int findmax(TreeNode root, int[] dia) {
        if(root==null) return 0;

        int leftH = findmax(root.left,dia);
        int rightH = findmax(root.right,dia);
        dia[0] = Math.max(dia[0], leftH+rightH);
        return 1+Math.max(leftH, rightH);
    }
}
