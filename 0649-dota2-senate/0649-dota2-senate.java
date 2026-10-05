class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();
        for(int i = 0;i < n;i++){
            char c = senate.charAt(i);
            if(c == 'R'){
                r.add(i);
            }
            else{
                d.add(i);
            }
        }
        while(!r.isEmpty() && !d.isEmpty()){
            if(r.peek() < d.peek()){
                r.add(r.peek()+n);
                
            }
            else{
                d.add(d.peek()+n);
            }
            r.remove();
            d.remove();
        }
        if(r.isEmpty()) return "Dire";
        return "Radiant";
        

    }
}