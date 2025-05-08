class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        Map<String, Integer> freq = new HashMap<>();

        for (int i = 0; i + minSize <= n; i++) {
            String sub = s.substring(i, i + minSize);
            if (countUnique(sub) <= maxLetters) {
                freq.put(sub, freq.getOrDefault(sub, 0) + 1);
            }
        }

        int ans = 0;
        for (int v : freq.values()) 
            ans = Math.max(ans, v);
        return ans;
    }

    private int countUnique(String t) {
        Set<Character> set = new HashSet<>();
        for (char c : t.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
