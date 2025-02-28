class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return list;
        }
        
        int start = nums[0];
        
        for(int i = 0 ; i < nums.length -1; i++){
            //구간 종료(start도 바꿔줌)
            if(nums[i] + 1 != nums[i+1]){
                StringBuilder sb = new StringBuilder();
                
                //start와 nums[i]가 같은 경우
                if(start == nums[i]) {
                    sb.append(Integer.toString(start));
                    list.add(sb.toString());
                }
                //다른 경우 
                else{
                    sb.append(Integer.toString(start));
                    sb.append("->");
                    sb.append(Integer.toString(nums[i]));
                    list.add(sb.toString());
                }
                start = nums[i + 1];
            }
             //구간이 종료하지 않은 경우 
        }

        //마지막 구간에 대한 처리
        if (start == nums[nums.length - 1]) {
            list.add(String.valueOf(start));
        } else {
            list.add(start + "->" + nums[nums.length - 1]);
        }

        return list;
    }
}