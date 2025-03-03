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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            double a = 0;
            for(int i = 0; i < size; i++){
                TreeNode t = q.poll();
                a += t.val;
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            list.add(a / size);
        }
        return list;
    }
}