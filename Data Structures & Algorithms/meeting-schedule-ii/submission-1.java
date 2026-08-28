class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int startPtr = 0, endPtr = 0;
        int activeRooms = 0, maxRooms = 0;

        while (startPtr < intervals.size()) {
            if (starts[startPtr] < ends[endPtr]) {
                // A meeting started before the earliest active meeting ended
                activeRooms++;
                startPtr++;
            } else {
                // A meeting ended, freeing up a room
                activeRooms--;
                endPtr++;
            }
            maxRooms = Math.max(maxRooms, activeRooms);
        }

        return maxRooms;
    }
}