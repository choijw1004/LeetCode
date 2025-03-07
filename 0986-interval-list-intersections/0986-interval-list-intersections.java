class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i=0, j=0;
        while(i < firstList.length && j < secondList.length){
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];

            int s2 = secondList[j][0];
            int e2 = secondList[j][1];

            int sMax = Math.max(s1, s2);
            int eMin = Math.min(e1,e2);

            if(sMax <= eMin) list.add(new int[] {sMax,eMin});

            if(e2 > e1) i++;
            else j++;

        }


        return list.toArray(new int[list.size()][]);
    }
}