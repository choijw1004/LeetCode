import java.util.*;
class Solution {
    List<String> list;
    String s;
    private void backTracking(int cnt, int start, List<String> tmp){
        if(cnt == 4){
            if(start == s.length()){
                list.add(String.join(".",tmp));
            }
        }
    
        for(int i = 1; i <=3 ;i++){
            if(start + i > s.length()) break;
            String seg = s.substring(start,start+i);

            if(seg.length() > 1 && seg.charAt(0)== '0') continue;

            int v = Integer.parseInt(seg);
            if(v > 255) continue;

            tmp.add(seg);
            backTracking(cnt +1, start +i, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        this.s = s;
        if(s.length() > 12) return list;
        
        //int cnt, int start, List<String> tmp
        backTracking(0,0,tmp);
        
        return list;
    }
}