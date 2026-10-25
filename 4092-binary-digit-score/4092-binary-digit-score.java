class Solution {
    public int convert(int x){
        String str = "";
        
        int temp = x;
        int count = 0;
        while(temp != 0){
            if(temp%2 == 1)count++;
            temp /= 2;
        }
        
        return count;
    }
    public int calculateScore(int a, int b) {
        int count1 = convert(a);
        int count2 = convert(b);
        
        if(count1 >= count2) return count1*count2;
        else return count2/count1;
    }
}