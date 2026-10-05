class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        for(int i = 1 ;i < n;i++){
            for(int j = i-1;j >= 0;j--){
                if(deck[j] >= deck[j+1]){
                    int temp = deck[j];
                    deck[j] = deck[j+1];
                    deck[j+1] = temp;
                }
                else{
                    break;
                } 
            }
        }
        int [] ans = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < n;i++){
            queue.add(i);
        }
        int i = 0;
        while(i < n){
            ans[queue.remove()] = deck[i++];
            queue.add(queue.peek());
            queue.remove();
        }

        return ans;

    }
}