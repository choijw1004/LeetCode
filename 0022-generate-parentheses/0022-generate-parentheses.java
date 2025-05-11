class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return result;
    }

    private void backtrack(int n, int open, int close, StringBuilder sb) {
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            backtrack(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backtrack(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
