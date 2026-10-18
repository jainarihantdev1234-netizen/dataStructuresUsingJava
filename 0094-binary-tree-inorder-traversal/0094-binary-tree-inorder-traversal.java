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
    private void inorder(TreeNode root,List<Integer> ans){
        // if(root == null) return;
        // inorder(root.left,ans);
        // ans.add(root.val);
        // inorder(root.right,ans);
        TreeNode temp = root;
        Stack<TreeNode> st = new Stack<>();

        while(true){
            if(temp != null){
                st.push(temp);
                temp = temp.left;
            }else{
                if(st.isEmpty()) break;
                TreeNode d = st.pop();
                ans.add(d.val);
                temp = d.right;
            }
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        inorder(root,ans);
        return ans;
    }
}