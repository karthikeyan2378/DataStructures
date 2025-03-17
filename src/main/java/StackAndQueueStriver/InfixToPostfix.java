package StackAndQueueStriver;

import java.util.Stack;

class InfixToPostfix {
    // Function to convert an infix expression to a postfix expression.
    public static int priority(char c)
    {
        if(c  == '^')
            return 3;
        else if(c == '*' || c == '/' )
            return 2;
        else if(c == '-' || c == '+')
            return 1;
        else
            return -1;
    }

    public static String infixToPostfix(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            }
            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If ')', pop until '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop(); // Remove '(' from stack
            }
            // Operator handling
            else {
                while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())) {
                    ans.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String postFix = infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
        System.out.println("postFix = " + postFix);
    }
}
