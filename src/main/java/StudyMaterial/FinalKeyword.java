package StudyMaterial;

public class FinalKeyword {
    // cannot re-assign the final variable will throw error
    final int test =1;

    // a blank final variable
    final int CAPACITY;

    // another blank final variable
    final int  MINIMUM;

    // a final static variable PI direct initialize
    static final double PI = 3.141592653589793;

    // a  blank final static  variable
    static final double EULERCONSTANT;

    // instance initializer block for initializing CAPACITY
    {
        CAPACITY = 25;
    }

    // static initializer block for initializing EULERCONSTANT
    static{
        EULERCONSTANT = 2.3;
    }

    // constructor for initializing MINIMUM Note that if there are more than one constructor, you must initialize MINIMUM in them also
    public FinalKeyword()
    {
        MINIMUM = -1;
    }

    public static void main(String[] args) {

        // reference final variable we can change value runtime
        final StringBuilder sb = new StringBuilder("Geeks");
        sb.append("ForGeeks");
        System.out.println("sb = " + sb);

        /* Properties of Final Keyword*/

        /*
        * Ensuring immutability: When a variable or reference is marked as final, its value cannot be changed once it is assigned. This helps ensure that data is immutable and cannot be accidentally or maliciously modified.
        *
        * Improving performance: The use of final can sometimes help improve performance, as the Java Virtual Machine (JVM) can optimize code more effectively when it knows that certain values or references cannot be changed.
        *
        * Making code easier to understand: By declaring variables, methods, or classes as final, developers can make their code easier to understand and reason about. When a value or reference is marked as final, it is clear that it will not change, which can simplify code analysis and debugging.
        *
        * Promoting code reuse: By declaring methods as final, developers can prevent subclasses from overriding them. This can help promote code reuse and reduce duplication, as subclasses must use the parent class’s implementation of the method.
        *
        * Enhancing security: The use of final can help enhance security by preventing malicious code from modifying sensitive data or behavior.
        */

    }
}
