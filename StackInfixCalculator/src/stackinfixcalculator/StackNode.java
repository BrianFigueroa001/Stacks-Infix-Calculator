
package stackinfixcalculator;

public class StackNode {
    private String token;
    private StackNode next;
    
    public StackNode(String expression, StackNode top){
        token = expression;
        next = top;
    }
    
    public String getToken(){
        return token;
    }
    
    public StackNode getNext(){
        return next;
    }
    
}
