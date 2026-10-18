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
   
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public boolean preorder(TreeNode root,boolean flag){
        if(root == null) return flag;
        int lvl1 = 0;
        int lvl2 = 0;
        if(root.left != null){
            lvl1 = levels(root.left);
        }
        if(root.right != null){
            lvl2 = levels(root.right);
        }
        int diff = (lvl1 - lvl2);
        if(diff > 1 || diff < -1)return false;
        flag = preorder(root.left,flag);
        flag =preorder(root.right,flag);
        return flag;
    }
    public boolean isBalanced(TreeNode root) {
        boolean flag = true;
        flag = preorder(root,flag);
        return flag;
    }
}