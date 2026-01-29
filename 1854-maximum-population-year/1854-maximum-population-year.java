class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];

        for(int[] log : logs){
            arr[log[0] - 1950]++;
            arr[log[1] - 1950]--;
        }

        int currPop = 0;
        int max = -1;
        int year = 0;

        for(int i = 0 ; i < arr.length; i++){
            currPop += arr[i];

            if(currPop > max){
                max = currPop;
                year = i + 1950;
            }            
        }

        return year;
        
    }
}