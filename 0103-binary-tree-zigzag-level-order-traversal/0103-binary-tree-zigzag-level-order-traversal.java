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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> rt = new ArrayList<>();
        
        if(root == null) return rt;

        q.offer(root);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            Stack<Integer> s = new Stack<>();
            List<Integer> list = new ArrayList<>();

            for(int i = 0 ; i < size; i++){
                TreeNode t = q.poll();
                s.push(t.val);
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            int sSize = s.size();
            for(int i = 0 ; i < sSize; i++){
                if(level % 2 == 1) list.add(s.get(i));
                else list.add(s.pop());
            }

            rt.add(list);
            level++;
        }
        return rt;
    }
}