class Solution {
    public String decodeString(String s) {
       Stack<Character> st = new Stack<>();
        int n = s.length();
       for(char c : s.toCharArray()){
            if(c != ']'){
                st.push(c);
            }
            else{
                StringBuilder sb = new StringBuilder();

                while(st.peek() != '['){
                    sb.append(st.pop());
                }

                //remove '['
                st.pop();

                int base = 1;
                int k = 0;

                //finding number
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    k = (st.pop() - '0') * base + k;
                    base *= 10;
                }

                //multiplying by times
                while(k > 0){
                    for(int i = sb.length()-1;i>=0;i--){
                        st.push(sb.charAt(i));
                    
                    }
                    k--;
                }

            }
       }
        char[] ch = new char[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            ch[i] = st.pop();
            
        }

        return new String(ch);
    }
}