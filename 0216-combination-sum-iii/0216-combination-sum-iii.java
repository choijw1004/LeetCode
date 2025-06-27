class Solution {
    List<List<Integer>> ans;
    int k, n;

    private void dfs(int start, int sum, int count, List<Integer> list) {
        if (count == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (sum > n) return;

        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(i + 1, sum + i, count + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.ans = new ArrayList<>();
        this.k = k;
        this.n = n;

        // 1부터 시작
        dfs(1, 0, 0, new ArrayList<>());
        return ans;
    }
}
