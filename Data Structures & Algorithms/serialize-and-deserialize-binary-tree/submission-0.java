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

public class Codec {
    int ind =0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString();


    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append("N"+" ");
            return;
        }
        
        sb.append(root.val + " ");
        dfs(root.left,sb);
        dfs(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] val = data.split(" ");

        return dfs(val);
    }

    public TreeNode dfs(String[] val) {
        if(val[ind].equals("N")) {
            ind++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val[ind]));
        ind++;
        node.left = dfs(val);
        node.right = dfs(val);
        return node;

    }
}
