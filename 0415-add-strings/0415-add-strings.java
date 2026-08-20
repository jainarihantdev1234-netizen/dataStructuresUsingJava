class Solution {
    
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder string = new StringBuilder();
        int sum = 0;
        while(i != -1 && j != -1){
            int d1 = num1.charAt(i)-'0';
            int d2 = num2.charAt(j)-'0';
            sum = d1 + d2 + carry;
            carry = sum/10;
            string.append(sum%10);
            i--;
            j--;
        }
        while(i != -1 && j == -1){
            int d1 = num1.charAt(i)-'0';
            sum = d1 + carry;
            carry = sum/10;
            string.append(sum%10);
            i--;
        }
        while(i == -1 && j != -1){
            int d2 = num2.charAt(j)-'0';
            sum = d2 + carry;
            carry = sum/10;
            string.append(sum%10);
            j--;
        }
        if(carry != 0){
            string.append(carry);
        }
        
        

       
        return string.reverse().toString();
    }
}