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

    public List<Integer> inorder(List<Integer> arr,TreeNode root,int k){
        if(root == null) return arr;
        arr = inorder(arr,root.left,k);
        arr.add(root.val);
        arr = inorder(arr,root.right,k);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(arr,root,k);
        return arr.get(k-1);
    }
}