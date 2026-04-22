import java.util.*;

class Solution {
    List<List<Integer>> ans;
    List<Integer> list;
    int n,k;

    private void comb(int start, int cnt, List<Integer> tmp){
        if(cnt == k){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = start; i < list.size(); i++){
            tmp.add(list.get(i));
            comb(i + 1, cnt + 1, tmp);
            tmp.remove(tmp.size() -1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        this.ans = new ArrayList<>();
        this.n = n;
        this.k = k;

        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        comb(0, 0, new ArrayList<>());
        return ans;
    }
}