class Solution {
    public boolean isValid(String a, String b){
        int cnt = 0;
        for(int i = 0 ; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt == 1 ? true : false;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];

        q.offer(beginWord);
        int rt = 1;
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size; i++){
                String s = q.poll();
                
                for(int j = 0; j < visited.length; j++){
                    if(isValid(wordList.get(j), s) && !visited[j]){
                        visited[j] = true;
                        if(wordList.get(j).equals(endWord)){
                            flag = true;
                            return rt +1; 
                        }
                        q.offer(wordList.get(j));
                    }
                }

            }
            rt++;
        }
        return flag == true ? rt: 0;
    }
}