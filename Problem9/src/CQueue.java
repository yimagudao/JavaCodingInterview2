import java.util.Stack;

/**
 * @author William Mou
 * @date 2019/1/17 21:24
 */
public class CQueue<E> {
    private Stack<E> stack1;
    private Stack<E> stack2;
    public CQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void appendTail(E element){
        stack1.push(element);
    }
    public E deleteHead(){
        if (stack2.isEmpty()){
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            throw  new RuntimeException();
        }
        return stack2.pop();
    }
}
