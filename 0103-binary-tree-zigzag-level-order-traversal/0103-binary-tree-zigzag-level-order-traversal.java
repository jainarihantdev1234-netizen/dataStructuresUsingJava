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

    public void reverse(List<Integer> arr){
        int i = 0;
        int j = arr.size()-1;
        while(i < j){
            int a = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,a);
            i++; j--;  
        }
        return;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelorder(root,ans);
        for(int i = 0 ; i < ans.size();i++){
            if(i % 2 != 0){
                reverse(ans.get(i));
            }
        }
        return ans;
    }
}