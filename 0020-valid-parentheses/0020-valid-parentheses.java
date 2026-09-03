class Solution {
    
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int flag = 0;
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.push(c);


            }
            else{ 
                if(st.isEmpty()){
                    return false;
                }
                
                if(c == ')'){
                    if(st.peek() == '('){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                if(c == '}'){
                    if(st.peek() == '{'){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                if(c == ']'){
                    if(st.peek() == '['){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(st.isEmpty() == false){
            return false;
        }
        return true;
    }
}