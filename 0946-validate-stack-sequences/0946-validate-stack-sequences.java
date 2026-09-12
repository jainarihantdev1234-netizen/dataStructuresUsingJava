class Solution {
    public boolean validateStackSequences(int[] arr, int[] pop) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for(int i = 0;i < n;i++){
            st.push(arr[i]);
            while(!st.isEmpty() && st.peek() == pop[j]){
                st.pop();
                j++;
            }
        }
        if(j == n){
            return true;
        }
        else{
            return false;
        }
    }
}