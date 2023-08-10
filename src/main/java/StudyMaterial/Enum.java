package StudyMaterial;

enum Color {
    RED,
    YELLOW,
    GREEN
        }
public class Enum {
    enum Days{
        SUNDAY,
        Monday
    }
    public static void main(String[] args) {
        Color c = Color.RED;
        System.out.println("c = " + c);
        Days d = Days.Monday;
        System.out.println("d = " + d);
        /* Enum cannot be declared inside the method */

        /* PROPERTIES OF ENUM */

        /*
        * There are certain properties followed by Enum as mentioned below:

        1. Every enum is internally implemented by using Class.
        2. Every enum constant represents an object of type enum.
        3. Enum type can be passed as an argument to switch statements.
        4. Every enum constant is always implicitly public static final. Since it is static, we can access it by using the enum Name. Since it is final, we can’t create child enums.
        5. We can declare the main() method inside the enum. Hence we can invoke the enum directly from the Command Prompt.
        6. Enum constructors should always be private.
        7. ordinal --> index of enum
        8. valueOf ---> value of enum
        9. cannot create instance since it has private constructor.
* */
    }
}
