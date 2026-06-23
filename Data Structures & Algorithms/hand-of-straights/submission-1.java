class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        Map<Integer,Integer> m = new HashMap<>();
        for(int i:hand){
            m.put(i,m.getOrDefault(i,0)+1);
        }

        for(int i:hand){
            int start = i;
            while(m.getOrDefault(start-1,0)>0) start--;
            while(start<=i){
                 while (m.getOrDefault(start, 0) > 0) {
                    for (int k = start; k < start + groupSize; k++) {
                        if (m.getOrDefault(k, 0) == 0) return false;
                        m.put(k, m.get(k) - 1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
