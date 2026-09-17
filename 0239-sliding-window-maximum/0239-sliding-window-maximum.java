class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n-1] = n;
        st.push(n-1);
        for(int i = n-2;i >= 0;i--){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]) st.pop();
            if(st.isEmpty()) nge[i] = n;
            else{
                nge[i] = st.peek(); 
            }
            st.push(i);
        }

        int[] ans = new int[n-k+1];
        int z = 0;
        int j = 0;
        for(int i = 0;i < n-k+1;i++){
            if(j >= i+k) j = i;

            int max = arr[j];
            while(j < i+k){
                max = arr[j];
                j = nge[j];
            }
            ans[z++] = max; 
        }

        return ans;
        
    }
}