class Solution {
    List<List<Integer>> ans;
    int target;
    int[] arr;

    private void comb(int start, List<Integer> list, int sum) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            comb(i, list, sum + arr[i]);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        this.target = target;
        this.arr = candidates;
        comb(0, new ArrayList<>(), 0);
        return ans;
    }
}
