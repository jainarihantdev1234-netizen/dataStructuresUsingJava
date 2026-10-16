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

    public void addLevels(TreeNode root,int curLevel,int i,List<Integer> arr){
        if(root == null) return;
        if(curLevel > i) return;
        if(curLevel == i) arr.add(root.val);
        addLevels(root.left,curLevel+1,i,arr);
        addLevels(root.right,curLevel+1,i,arr);
    }
    public int level(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(level(root.left),level(root.right));

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int levels = level(root);

        for(int i = 0;i < levels;i++){
            List<Integer> arr = new ArrayList<>();
            addLevels(root,0,i,arr);
            ans.add(arr);
        }

        return ans;
    }
}