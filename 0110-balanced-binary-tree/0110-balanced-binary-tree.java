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
    static boolean flag = true;
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public void preorder(TreeNode root){
        if(root == null) return;
        int lvl1 = 0;
        int lvl2 = 0;
        if(root.left != null){
            lvl1 = levels(root.left);
        }
        if(root.right != null){
            lvl2 = levels(root.right);
        }
        int diff = (lvl1 - lvl2);
        if(diff > 1 || diff < -1){
            flag = false;
            return;
        }         
        preorder(root.left);
        preorder(root.right);
    }
    public boolean isBalanced(TreeNode root) {
        flag = true;
        preorder(root);
        return flag;
    }
}