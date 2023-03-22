import java.util.*;

public class MinumumElement {
    static Stack<Integer> myStack = new Stack<Integer>();// maintainig a stack for push pop and get minimum Element
    static Stack<Integer> minStack = new Stack<>();// stack to maintain the minElemnts

    public static void main(String[] args) { // code controller
        // operations to update the stack
        push(8);
        push(2);
        push(1);
        push(7);
        push(4);
        getminimum();
        System.out.println(pop());
        pop();
        pop();
        System.out.println(getminimum());
        pop();

    }

    public static void push(int element) {

        if (myStack.isEmpty()) { // check wheter stack empty or not if empty then incoming element is a minimum
                                 // element

            myStack.push(element);
            minStack.push(element);

            return;
        }
        if (element < minStack.peek()) {

            minStack.push(element);
            myStack.push(element);

        } else {
            myStack.push(element); // if element greater than minelemnt than siply push it to stack
        }
    }

    public static int pop() {

        int top = myStack.pop();
        if (top == minStack.peek()) {
            minStack.pop();

        }
        return top;

    }

    public static int getminimum() {

        return minStack.peek();// prints the minimum elemnet in 0(1)
    }
}
