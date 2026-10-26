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

    public List<Integer> inorder(List<Integer> arr,TreeNode root,int k,int[] count){
        if(root == null) return arr;
        arr = inorder(arr,root.left,k,count);
        arr.add(root.val);
        count[0]++;
        if (count[0] == k) return arr;
        arr = inorder(arr,root.right,k,count);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        int[] count = new int[1];
        inorder(arr,root,k,count);
        return arr.get(k-1);
    }
}