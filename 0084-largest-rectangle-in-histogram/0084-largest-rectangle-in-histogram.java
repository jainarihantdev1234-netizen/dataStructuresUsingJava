import java.util.Stack;
class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int c= 0;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int[] ans1 = new int[n];
        int[] ans2 = new int[n];
        ans1[0] = -1;
        st1.push(0);
        for(int i = 1;i < n;i++)
        {
            while(!st1.isEmpty() && arr[i] <= arr[st1.peek()]) st1.pop();
            if(st1.isEmpty()){
                ans1[i] = -1;
            }
            else{
                ans1[i] = st1.peek();
            }
            st1.push(i);
        }
        
        ans2[n-1] = n;
        
        st2.push(n-1);
        for(int i = n-2;i >= 0;i--)
        {
            while(!st2.isEmpty() && arr[i] <= arr[st2.peek()]) st2.pop();
            if(st2.isEmpty()){
                ans2[i] = n;
            }
            else{
                ans2[i] = st2.peek();
            }
            st2.push(i);
        }
        int max = 0;
        int prod = 0;
        for(int i = 0;i < n;i++) {
    
            prod = arr[i] * (ans2[i] - ans1[i] -1);
            if(prod > max){
                max = prod;
            }
        }

        return max;

    }
}