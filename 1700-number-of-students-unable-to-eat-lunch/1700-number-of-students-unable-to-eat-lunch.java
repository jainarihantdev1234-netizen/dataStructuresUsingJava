class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int size = students.length;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < students.length;i++){
            queue.add(students[i]);
        }
        for(int i = sandwiches.length-1;i >= 0;i--){
            stack.push(sandwiches[i]);
        }
        while(!stack.isEmpty()){
            if(queue.peek() == stack.peek()){
            queue.remove();
            stack.pop();
            size--;
            count = 0;

            }
            else{
                queue.add(queue.peek());
                queue.poll();
                count++;
                if(count > students.length && queue.peek() != stack.peek()){
                    break;
                }
            }
        }
        return size;

    }
}