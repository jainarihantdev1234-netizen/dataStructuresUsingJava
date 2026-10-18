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
    public void rightView(TreeNode root,int cur,int i,List<Integer> ans,int[] flag ){
        if(root == null) return;
        if(cur > i) return;
        if(cur == i){
            if(flag[0] == 0){
                ans.add(root.val);
                flag[0] = 1;
            }
        }
        rightView(root.right,cur+1,i,ans,flag);
        rightView(root.left,cur+1,i,ans,flag);


    }
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        int lvl = levels(root);
        int[] flag = new int[1];
        for(int i = 0;i < lvl; i++){
            flag[0] = 0;
            rightView(root,0,i,ans,flag);
        }
        
        return ans;
    }
}