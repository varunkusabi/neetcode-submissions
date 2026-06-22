class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> m = new HashMap<>();
        for (int card : hand) {
            m.put(card, m.getOrDefault(card, 0) + 1);
        }
        for(int i=0;i<hand.length;i++){
            int curr = hand[i];
            if(m.get(curr)==0){
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int next = curr + j;
                if (m.getOrDefault(next, 0) <= 0) {
                    return false;
                }
                m.put(next, m.get(next) - 1);
            }
        }
        return true;
    }
}
