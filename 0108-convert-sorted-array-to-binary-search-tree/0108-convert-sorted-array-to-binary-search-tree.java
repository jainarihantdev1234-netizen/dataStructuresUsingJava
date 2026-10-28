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
    
    public TreeNode treeConstructor(int left,int right,int[] nums){
        if(left > right) return null;
        

        
        int mid = left + (right-left)/2;
        TreeNode root1 = new TreeNode(nums[mid]);    
        root1.left = treeConstructor(left,mid-1,nums);
        root1.right = treeConstructor(mid+1,right,nums); 
        
        return root1;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        
        return treeConstructor(0,n-1,nums);

    }
}