class MyQueue {

    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack<Integer>();
        second = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(first.isEmpty()) {
            first.push(x);
            return;
        }
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        second.push(x);
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return;
    }
    
    public int pop() {
        if(first.isEmpty()) return -1;
        return first.pop();
    }
    
    public int peek() {
        if(first.isEmpty()) return -1;
        return first.peek();
    }
    
    public boolean empty() {
        if(first.isEmpty()) return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */