
package stackinfixcalculator;

public class Stack {
    private StackNode top;
    
    public void push(String token){
        StackNode newTop = new StackNode(token, top);
        top = newTop;
    }
    
    public String pop(){
        String poppedToken = top.getToken();
        top = top.getNext();
        return poppedToken;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    
}
