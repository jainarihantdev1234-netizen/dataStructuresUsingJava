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
    public List<TreeNode> inorder(TreeNode root,int[] prev){
        // if(root == null) return arr;
        // arr = inorder(root.left,arr);
        // arr.add(root);
        // arr = inorder(root.right,arr);
        // return arr;
        if(root == null) return null;
        inorder(root.right,prev);
        root.val = root.val+prev[0];
        prev[0] = root.val;
        return inorder(root.left,prev);
    }
    public TreeNode bstToGst(TreeNode root) {
        // List<TreeNode> arr = new ArrayList<>();
        // arr = inorder(root,arr);
        // int n = arr.size();
        // int sum = 0;
        // for(int i = n-1;i >= 0;i--){
        //     arr.get(i).val += sum;
        //     sum = arr.get(i).val;
        // }
        // return root;
        int[] prev = new int[1];
        prev[0] = 0;
        inorder(root,prev);

        return root;
    }
}