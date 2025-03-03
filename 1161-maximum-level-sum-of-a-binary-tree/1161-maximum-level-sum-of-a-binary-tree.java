/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<TreeNode>();
         
        q.offer(root);
        int max = Integer.MIN_VALUE;
        int level = 1;
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int num = 0;
            for(int i = 0 ; i < size; i++){
                TreeNode t = q.poll();
                
                num += t.val;

                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);

            }

            if(num > max){
                max = num;
                ans = level;
            }

            level++; 
        }
        return ans;
    }
}