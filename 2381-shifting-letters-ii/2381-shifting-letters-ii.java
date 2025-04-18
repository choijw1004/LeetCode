class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n+1];

        for (int[] shift : shifts) {
            int l = shift[0], r = shift[1];
            int d = (shift[2] == 1 ? 1 : -1);
            diff[l]   += d;
            diff[r+1] -= d;
        }

        StringBuilder sb = new StringBuilder(n);
        int acc = 0;
        for (int i = 0; i < n; i++) {
            acc += diff[i];
            int t = acc % 26;
            if (t < 0) t += 26;

            int origin = s.charAt(i) - 'a';
            int moved  = (origin + t) % 26;
            sb.append((char)('a' + moved));
        }

        return sb.toString();
    }
}
