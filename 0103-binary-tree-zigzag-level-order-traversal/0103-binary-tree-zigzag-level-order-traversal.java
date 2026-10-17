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

    public int levels(TreeNode root){
        if(root == null) return 0;

        return 1+Math.max(levels(root.left),levels(root.right));
    }

    public void order1(TreeNode root,int cur,int i,List<Integer> arr){
        if(root == null) return;
        if(cur > i){
            return;
        }
        if(cur == i){
            arr.add(root.val);
        }
        order1(root.left,cur+1,i,arr);
        order1(root.right,cur+1,i,arr);
        
    }
    public void order2(TreeNode root,int cur,int i,List<Integer> arr){
        if(root == null) return;
        if(cur > i){
            return;
        }
        if(cur == i){
            arr.add(root.val);
        }
        order2(root.right,cur+1,i,arr);
        order2(root.left,cur+1,i,arr);
        
        
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // List<List<Integer>> ans = new ArrayList<>();
        // levelorder(root,ans);
        // for(int i = 0 ; i < ans.size();i++){
        //     if(i % 2 != 0){
        //         reverse(ans.get(i));
        //     }
        // }
        // return ans;
        List<List<Integer>> ans = new ArrayList<>();
        int level = levels(root);

        for(int i = 0; i < level ; i++){
            List<Integer> arr = new ArrayList<>();
            if(i % 2 == 0) order1(root,0,i,arr);
            else order2(root,0,i,arr);
            ans.add(arr);
        }

        return ans;
    }
}