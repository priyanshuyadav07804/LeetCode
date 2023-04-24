
class Solution {
    public static Stack<Character> s = new Stack<>();
    
    public String pushString(String str,Stack<Character> s){
        for(int i = 0;i<str.length();i++){
            s.push(str.charAt(i));
        }
        String newString = new String("");
        while(!s.isEmpty()){
            char top = s.pop();
            newString = newString + top;
        }
        return newString;
        
    }
    
    public String reverse(String S){
        //code here
        S = pushString(S,s);
        // while(!s.isEmpty()){
        //     System.out.print(s.pop());
        // }
        return S;
        
    }
}
