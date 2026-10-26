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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int hi) {
        if(root == null) return sum;
        if(root.val >= low && root.val <= hi) sum += root.val;
        if(root.val < low) sum = rangeSumBST(root.right,low,hi);
        if(root.val > hi) sum = rangeSumBST(root.left,low,hi);
        if(root.val >= low && root.val <= hi){
            sum = rangeSumBST(root.right,low,hi);
            sum = rangeSumBST(root.left,low,hi);
        }
        return sum;


    }
}