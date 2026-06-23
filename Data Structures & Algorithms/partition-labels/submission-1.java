class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] m=new int[26][2];
        for(int i=0;i<26;i++){
            Arrays.fill(m[i],-1);
        }

        for(int i=0;i<s.length();i++){
            int ind = s.charAt(i)-'a';
            if(m[ind][0]==-1){
                m[ind][0]=i;
            }
            m[ind][1]=i;
        }

        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (m[i][0] != -1) {
                intervals.add(m[i]);
            }
        }

        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int n = intervals.size();

        while(i<n){
            int start = intervals.get(i)[0];
            int end = intervals.get(i)[1];
            int j=i+1;
            while(j<n && intervals.get(j)[0]<end){
                end = Math.max(end,intervals.get(j)[1]);
                j++;
            }

            int stringLength = end-start+1;
            result.add(stringLength);

            i=j;
        }

        return result;

    }
}
