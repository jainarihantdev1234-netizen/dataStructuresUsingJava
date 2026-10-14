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
    public int levels(TreeNode r,int max[]){
        if(r == null) return 0;
        int leftLevel = levels(r.left,max);
        int rightLevel = levels(r.right,max);
        max[0] = Math.max(max[0],(leftLevel + rightLevel));
        return 1 + Math.max(leftLevel,rightLevel);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        max[0] = 0;
        levels(root,max);
        return max[0];
    }
}