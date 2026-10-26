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

    public TreeNode insert(TreeNode root,int val){
        if(root == null){
            TreeNode root1 = new TreeNode(val); 
            return root1;
        }else{
            if(root.val < val) root.right = insert(root.right,val);
            if(root.val > val) root.left = insert(root.left,val);
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){

        }
        root = insert(root,val);
        return root;
    }
}