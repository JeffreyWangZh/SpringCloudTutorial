package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author jw9j
 * @create 2021/6/14 1:30
 */
public class Offer09 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public Offer09() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) {
            return -1;
        }else{
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }
}
