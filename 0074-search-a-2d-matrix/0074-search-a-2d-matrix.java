class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        if(m == 0) return false;
        
        int row = -1;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] <= target && target <= matrix[mid][m - 1]){
                row = mid;
                break;
            } else if(target < matrix[mid][0]){
                right = mid - 1;
            } else { 
                left = mid + 1;
            }
        }
        
        if(row == -1) return false;
        
        left = 0;
        right = m - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
    }
}
