class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[52];

        for(int[] range : ranges){
            int start = range[0];
            int end = range[1];
            arr[start]++;
            arr[end + 1] --;
        }

        int sum = 0;

        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i];

            if(i >= left && i <= right && sum == 0) return false;
        }
        
        return true;
    }
}