class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = Integer.MIN_VALUE;
        int n = cardPoints.length;
        int start = n - k;
        int end = n - k;
        int maxEnd = n + k - 1;
        int size = k;
        int sum = 0;
        
        int[] arr = new int[n*2];

        for(int i = 0 ; i < n; i++){
            arr[i] = cardPoints[i];
            arr[i + n] = cardPoints[i];
        }

        while(end <= maxEnd){
            if(end - start + 1 < size){
                sum += arr[end];
                end++;
            }
            else{
                sum += arr[end];

                max = Math.max(sum, max);

                sum -= arr[start];
                
                start++;
                end++;
            }
        }

        return max;
    }
}