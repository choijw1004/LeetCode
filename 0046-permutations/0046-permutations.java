class Solution {
    List<List<Integer>> ans;
    int n;
    boolean[] used;
    int[] arr;

    private void perm(List<Integer> list){
        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            used[i] = true;
            list.add(arr[i]);

            perm(list);

            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        this.n = nums.length;
        this.arr = nums;
        this.used = new boolean[n];  

        perm(new ArrayList<>());
        return ans;
    }
}
