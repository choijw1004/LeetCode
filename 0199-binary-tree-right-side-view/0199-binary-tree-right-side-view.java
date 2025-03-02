class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode t = q.poll();
                if(t == null) continue;  

                if(i == size - 1) {
                    result.add(t.val);
                }
                
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
        }
        return result;
    }
}
