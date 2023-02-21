class Solution {
    public int strStr(String a, String b) {
        int k = b.length();
        for(int i=0;i<a.length()-k+1;i++){
            if(a.substring(i,i+k).equals(b)){
                return i;
            }
        }
        return -1;
    }
}
