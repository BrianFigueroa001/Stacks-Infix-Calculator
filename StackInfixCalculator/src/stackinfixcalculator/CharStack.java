
package stackinfixcalculator;

public class CharStack {
    private CharStackNode top;
    
    public void push(char data){
        CharStackNode newTop = new CharStackNode(data, top);
        top = newTop;
    }
    
    public char pop(){
        char data = top.getData();
        top = top.getNext();
        return data;
    }
    
    public char peek()
    {
        return top.getData();
    }
    
    public boolean isEmpty(){
        return top == null;
    }
}
