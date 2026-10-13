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
    public void mirror(TreeNode root){
        if(root == null) return;
        TreeNode dummy = root.left;
        root.left = root.right;
        root.right = dummy;
        mirror(root.left);
        mirror(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        mirror(root);
        return root;
    }
}