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
    public void addPath(TreeNode root,String str,List<String> ans){
        if(root == null) return;
        if(root.left == null && root.right == null){
            str += root.val;
            ans.add(str);
            return;
        }
        addPath(root.left,str+root.val+"->",ans);
        addPath(root.right,str+root.val+"->",ans);

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        addPath(root,"",ans);
        return ans;
    }
}