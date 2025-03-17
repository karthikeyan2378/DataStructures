package StackAndQueueStriver;

import java.util.Stack;

class MInStack {

    Stack<Long> s = new Stack<>(); // Use Long to prevent overflow
    long min;
    public MInStack() {
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(s.isEmpty())
        {
            min = val;
            s.push((long)val);
        }
        else if(val>=min)
        {
            s.push((long)val);
        }
        else
        {
            s.push(2L*val-min);
            min = val;
        }
    }

    public void pop() {
        if(s.isEmpty()){
            return;
        }
        long x = s.pop();

        if(x<min)
            min = 2*min-x;


        if (s.isEmpty()) { // Reset min when stack is empty
            min = Integer.MAX_VALUE;
        }

    }

    public int top() {
        if(s.isEmpty())
            return -1;

        long x= s.peek();

        if(min<=x)
            return (int)x;

        return (int)min;
    }

    public int getMin() {
        return (int)min;
    }

    public static void main(String[] args) {

    }
}
