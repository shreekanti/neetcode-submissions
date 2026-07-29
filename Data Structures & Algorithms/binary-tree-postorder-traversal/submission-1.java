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

    class Pair{
        TreeNode node;
        boolean vis;

        public Pair(TreeNode node, boolean vis) {
            this.node=node;
            this.vis=vis;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(new Pair(root, false));

        while(!st.isEmpty()) {
            Pair pair = st.pop();

            if(pair.node==null) {
                continue;
            }else if(pair.vis==true) {
                ans.add(pair.node.val);
            }else {
                st.push(new Pair(pair.node,true));
                st.push(new Pair(pair.node.right,false));
                st.push(new Pair(pair.node.left, false));
            }

        }
        return ans;
        
    }
}