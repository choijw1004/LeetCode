class Solution {
    List<List<Integer>> ans;
    int[] arr;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.arr = candidates;
        this.target = target;
        this.ans = new ArrayList<>();
        comb(0, new ArrayList<>(), 0);
        return ans;
    }

    private void comb(int idx, List<Integer> list, int sum) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;

            list.add(arr[i]);
            comb(i + 1, list, sum + arr[i]);
            list.remove(list.size() - 1);
        }
    }
}
