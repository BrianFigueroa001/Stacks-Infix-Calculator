
package stackinfixcalculator;

public class CharStackNode {
    private char data;
    private CharStackNode next;
    
    public CharStackNode(char data, CharStackNode top){
        this.data = data;
        next = top;
    }
    
    public char getData(){
        return data;
    }
    
    public CharStackNode getNext(){
        return next;
    }
    
}
