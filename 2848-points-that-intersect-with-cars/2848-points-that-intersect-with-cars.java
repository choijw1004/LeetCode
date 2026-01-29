class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] arr = new int[102];

        for(List<Integer> list : nums){
            arr[list.get(0)]++;
            arr[list.get(1) + 1]--;
        }

        int sum = 0;
        int cnt = 0;

        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i];

            if(sum >= 1) cnt++;            
        }
        return cnt;
        
    }
}