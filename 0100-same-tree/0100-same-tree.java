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
    private int checkSame(TreeNode t1,TreeNode t2,int flag){
        if(t1 == null && t2 == null) return flag;
        if((t1 == null && t2 != null) || (t1 != null && t2 == null) || (t1.val != t2.val)) return 0;
        flag = checkSame(t1.left,t2.left,flag);
        flag = checkSame(t1.right,t2.right,flag);
        return flag;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        int flag = 1;
        flag = checkSame(p,q,flag);
        if(flag == 1){
            return true;
        }else{
            return false;
        }
    }
}