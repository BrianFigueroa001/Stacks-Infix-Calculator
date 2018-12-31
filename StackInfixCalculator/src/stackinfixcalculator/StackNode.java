
package stackinfixcalculator;

public class StackNode {
    private String data;
    private StackNode next;
    
    public StackNode(String data, StackNode top){
        this.data = data;
        next = top;
    }
    
    public String getData(){
        return data;
    }
    
    public StackNode getNext(){
        return next;
    }
    
}
