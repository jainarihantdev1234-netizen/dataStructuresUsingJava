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
        public boolean check(TreeNode root1,TreeNode root2,boolean flag){
            if(root1 == null && root2 == null) return flag;
            if(root1 == null || root2 == null) return false;
            if(root1.val != root2.val) return false;
            flag = check(root1.left,root2.right,flag);
            flag = check(root1.right,root2.left,flag);
            return flag;
            

        }
    public boolean isSymmetric(TreeNode root) {
        boolean flag = true;
        flag = check(root.left,root.right,flag);
        return flag;
    }
}