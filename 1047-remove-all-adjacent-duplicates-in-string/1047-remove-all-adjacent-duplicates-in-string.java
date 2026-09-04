class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && c == st.peek()){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }


        return sb.reverse().toString();
    }
}