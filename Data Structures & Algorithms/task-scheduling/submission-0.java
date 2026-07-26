class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : count) {
            if (freq > 0) {
                maxHeap.add(freq);
            }
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !cooldownQueue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int remTime = maxHeap.poll()-1;
                if(remTime>0){
                    cooldownQueue.add(new int[]{remTime,time+n});
                }
            }
            if(!cooldownQueue.isEmpty()&& cooldownQueue.peek()[1] == time){
                maxHeap.add(cooldownQueue.poll()[0]);
            }
        }

        
        return time;
    }
}
