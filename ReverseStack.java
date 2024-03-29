class Solution
{ 
    public static void pushAtBottom(int data,Stack<Integer> s){
        if(s.isEmpty()){
         s.push(data);
         return;
        }
        int oldValue = s.pop();
        pushAtBottom(data,s);
        s.push(oldValue);
    }
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverse(s);
        pushAtBottom(top,s);
    }
}
