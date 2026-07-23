class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            maxHeap.add(i);
        }
        while(maxHeap.size()>1){
            int x =maxHeap.poll();
            int y =maxHeap.poll();
            if(x==y){
                continue;
            }
            else{
                maxHeap.add(Math.abs(x-y));
            }
        }
        if(maxHeap.size()==0){
            return 0;
        }
        return maxHeap.peek();
    }
}
