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
    public int function(TreeNode root,long sum){
        if(root == null) return 0;
        int count = 0;
        if(root.val == sum) count++;
        count += function(root.left,sum-root.val) + function(root.right,sum-root.val);
        return count;
    }
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return function(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
}