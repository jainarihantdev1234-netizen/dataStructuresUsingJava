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

    public List<Integer> copy(List<Integer> arr){
        List<Integer> list = new ArrayList<>();
        for(int ele : arr){
            list.add(ele);
        }
        return list;
    }

    public void function(TreeNode root,List<Integer> arr,List<List<Integer>> ans,int target){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(target == root.val){
                arr.add(root.val);
                ans.add(arr);
            }
            return;
        } 
    
        
        arr.add(root.val);
        
        List<Integer> arr1 = copy(arr);
        List<Integer> arr2 = copy(arr);
        if(root.left != null)function(root.left,arr1,ans,target-root.val);
        if(root.right != null)function(root.right,arr2,ans,target-root.val);
        
    } 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        function(root,arr,ans,targetSum);
        return ans;
    }
}