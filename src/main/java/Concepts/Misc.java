package Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Misc {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList(" apple", "bana  na", "oran  ge");

        Function<String, String> up = String::toUpperCase;
        Function<String, String>lower =String::toLowerCase;
        fruits.forEach(name->{
            System.out.println("up.andThen(F) = " + up.andThen(lower).andThen(String::length).apply(name));
        });

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Using Predicate to filter even numbers
        Predicate<Integer> isEvenPredicate = num -> num % 2 == 0;
        numbers.stream()
                .filter(isEvenPredicate)
                .forEach(System.out::println);

        UnaryOperator<Integer> squareOperator = num -> num * num;
        int squaredNumber = squareOperator.apply(5);
        System.out.println("Square: " + squaredNumber);

        // Using BinaryOperator to calculate sum
        BinaryOperator<Integer> sumOperator = Integer::sum;
        int sumResult = sumOperator.apply(3, 7);
        System.out.println("Sum: " + sumResult);
    }
}
