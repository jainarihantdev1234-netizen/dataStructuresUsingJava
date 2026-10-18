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
    public int levels(TreeNode root, int[] max){
        if(root == null ) return 0;
        int leftLevel = levels(root.left,max);
        int rightLevel = levels(root.right,max);
        int dia = leftLevel + rightLevel;
        max[0] = Math.max(dia,max[0]);
        return 1+ Math.max(leftLevel,rightLevel);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        max[0] = 0;
        levels(root,max);
        return max[0];
    }
}