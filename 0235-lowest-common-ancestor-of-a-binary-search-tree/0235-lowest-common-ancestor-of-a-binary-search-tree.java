/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = null;
        TreeNode right = null;
        if(root.val > p.val && root.val > q.val){
            left = lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val < p.val && root.val < q.val){
            right = lowestCommonAncestor(root.right,p,q);
        }
        else if(root.val > p.val && root.val < q.val || root.val < p.val && root.val > q.val){
            left = lowestCommonAncestor(root.left,p,q);
            right = lowestCommonAncestor(root.right,p,q);
        }
        if(left != null && right != null) return root;
        if(left != null && right == null) return left;
        if(left == null && right != null) return right;
        return null;
    }
}