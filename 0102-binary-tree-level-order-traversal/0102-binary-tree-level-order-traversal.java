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

 public class Pair{
    TreeNode node;
    int lvl;
    Pair(TreeNode t,int v){
        this.node = t;
        this.lvl = v;
    }
 }
class Solution {

    // public void addLevels(TreeNode root,int curLevel,int i,List<Integer> arr){
    //     if(root == null) return;
    //     if(curLevel > i) return;
    //     if(curLevel == i) arr.add(root.val);
    //     addLevels(root.left,curLevel+1,i,arr);
    //     addLevels(root.right,curLevel+1,i,arr);
    // }
    // public int level(TreeNode root){
    //     if(root == null) return 0;

    //     return 1 + Math.max(level(root.left),level(root.right));

    // }
    public void levelorder(TreeNode root,List<List<Integer>> ans){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        List<Integer> arr = new ArrayList<>();
        int prevLevel = 0;
        while(!q.isEmpty()){
            
            Pair temp = q.remove();
            TreeNode rt = temp.node;
            if(rt == null) return;
            int lvl = temp.lvl;
            if(prevLevel != lvl){
                ans.add(arr);
                arr = new ArrayList<>();
                prevLevel++;
            }

            arr.add(rt.val);
            if(rt.left != null) q.add(new Pair(rt.left,lvl+1));
            if(rt.right != null) q.add(new Pair(rt.right,lvl+1));

        }
        ans.add(arr);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List<List<Integer>> ans = new ArrayList<>();
        // int levels = level(root);

        // for(int i = 0;i < levels;i++){
        //     List<Integer> arr = new ArrayList<>();
        //     addLevels(root,0,i,arr);
        //     ans.add(arr);
        // }
        List<List<Integer>> ans = new ArrayList<>();
        levelorder(root,ans);

        return ans;
    }
}