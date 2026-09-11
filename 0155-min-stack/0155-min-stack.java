class MinStack {
    Stack<Long> st = new Stack<>();
    long min = 0;
    public MinStack() {
        
    }
    
    public void push(int value) {
        // if(st.isEmpty()){
        //     st.push(value);
        //     min.push(value);
        // }else{
        //     st.push(value);
        //     if(min.peek() < value){
        //         min.push(min.peek());
        //     }
        //     else{
        //         min.push(value);
        //     }
        // }
        long x = (long)value;
        if(st.isEmpty()){
            st.push(x);
            min = x;
        }
        else if(x >= min){
            st.push(x);
        }
        if(x < min){
            st.push(2*x - min);
            min = x;
        }
    }
    
    public void pop() {
        // st.pop();
        // min.pop();
        if(st.isEmpty()) return;
        if(st.peek() >= min) st.pop();
        else{
            long oldMin = 2*min-st.peek();
            min = oldMin;
            st.pop();
        }
    }
    
    public int top() {
        // return st.peek();
        long q = st.peek();
        if(st.isEmpty()) return -1;
        if(st.peek() >= min){
            return (int)q;
        }
        if(st.peek() < min){
            return (int)min;
        }
        return 0; 
    }
    
    public int getMin() {
        // return min.peek();
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */