
package stackinfixcalculator;

public class Stack {
    private StackNode top;
    
    public void push(String data){
        StackNode newTop = new StackNode(data, top);
        top = newTop;
    }
    
    public String pop(){
        String data = top.getData();
        top = top.getNext();
        return data;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
}
