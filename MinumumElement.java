import java.util.*;

public class MinumumElement {
    static Stack<Integer> myStack = new Stack<Integer>();// maintainig a stack for push pop and get minimum Element
    static int minElement; // a static variable which always hold minimum value

    public static void main(String[] args) { // code controller
        // operations to update the stack
        push(8);
        push(2);
        push(1);
        push(7);
        push(4);
        getminimum();
        pop();
        pop();
        pop();
        getminimum();
    }

    public static void push(int element) {
        if (myStack.isEmpty()) { // check wheter stack empty or not if empty then incoming element is a minimum
                                 // element
            minElement = element;

            myStack.push(element);
            return;
        }
        if (element < minElement) {
            /*
             * generating a flag which notify that the current operational value
             * are minimum or not and push that flag in stack and our minimum value holds
             * the incoming element
             */
            int number = 2 * element - minElement;
            minElement = element;
            myStack.push(number);
        } else {
            myStack.push(element); // if element greater than minelemnt than siply push it to stack
        }
    }

    public static void pop() {
        if (myStack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        int top = myStack.pop();
        if (top < minElement) {
            System.out.println(top);
            minElement = 2 * minElement - top;// pop value is our minimum value than we find our next min using reversed
                                              // of flag generating formula
        }

    }

    public static void getminimum() {
        if (myStack.isEmpty()) {
            System.out.println("Stack is empty"); // if empty than not possible
            return;
        }
        System.out.println(minElement);// prints the minimum elemnet in 0(1)
    }
}
