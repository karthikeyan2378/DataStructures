package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamsApi {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,2,3);
        System.out.println("a = " + a);
        Employee e = new Employee("Karthik", 21);
        Employee e1 = new Employee("ram", 24);
        Employee e2 = new Employee("ram", 21);
        List<Employee>list =  Arrays.asList(e,e1,e2);
        boolean b = list.stream().allMatch(p->p.getAge()>20);
        System.out.println("b = " + b);

        boolean b1 = list.stream().allMatch(p->p.getAge()>23);
        System.out.println("b1 = " + b1);

        Stream.Builder<String> builder = Stream.builder();
        builder.add("Hello");
        builder.add("World");
        Stream<String> build = builder.build();
        build.map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("build = " + build.toString());

        HashSet<String> collect = list.stream().map(Employee::getName)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
        System.out.println("collect = " + collect);

        Stream<Integer> firstStream = Stream.of(1, 2, 3);
        Stream<Integer> secondStream = Stream.of(4, 5, 6);
        Stream<Integer> resultingStream = Stream.concat(firstStream, secondStream);
        System.out.println("resultingStream.toString() = " + resultingStream.toString());

        long count = list.stream().count();
        System.out.println("count = " + count);

        List<String> distinctinon =
                list.stream().map(Employee::getName).distinct().collect(Collectors.toList());
        System.out.println("distinctinon = " + distinctinon);

        List<Employee> filterator = list.stream().filter(f -> f.getAge() > 21).collect(Collectors.toList());
        System.out.println("filterator.toString() = " + filterator.toString());

        Optional<Employee> any = list.stream().findAny();
        System.out.println("any = " + any);

        Optional<Employee> first = list.stream().findFirst();
        System.out.println("first = " + first);

        List<List<String>> flatMap = new ArrayList<>(Arrays.asList(
                Arrays.asList("Colombia", "Finland", "Greece", "Iceland", "Liberia", "Mali",
                        "Mauritius"),
                Arrays.asList("Peru", "Serbia", "Singapore", "Turkey", "Uzbekistan", "Yemen",
                        "Zimbabwe", "Greece", "Iceland")));

        System.out.println("flatMap = " + flatMap);

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("1", "2"),
                Arrays.asList("5", "6"),
                Arrays.asList("3", "4")
        );

        DoubleStream dStream = listOfLists.stream().flatMapToDouble(childList -> childList.stream()
                .mapToDouble(Double::new));

        System.out.println(Arrays.toString(dStream.toArray()));

        list.forEach(System.out::println);

        Stream.of("AAA","BBB","CCC").parallel().forEach(s->System.out.println("Output:"+s));
        Stream.of("AAA","BBB","CCC").parallel().forEachOrdered(s->System.out.println("Output:"+s));


        Stream<String> generate = Stream.generate(() ->
                Double.toString(Math.random() * 1000)).limit(10);


       generate.forEach(s -> System.out.println("s = " + s));



        System.out.println("listOfLists = " + listOfLists);
        Stream.iterate(0, n -> n + 1).limit(10).forEach(
                System.out::print
        );

        list.stream().map(Employee::getName).forEach(System.out::println);

        Optional<Employee> max =
                list.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println("max = " + max);

        Optional<Employee> min =
                list.stream().min(Comparator.comparingInt(Employee::getAge));

        System.out.println("min = " + min);

        boolean b2 = list.stream().noneMatch(g -> g.getAge() < 32);

        System.out.println("b2 = " + b2);

        List<String> hello_world = Stream.of("Hello World", "gggg").map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("hello_world = " + hello_world);

        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.peek(System.out::println);

        Optional<Integer> reduce = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce((a1, b11) -> a1 + b11);
        System.out.println(reduce.get());

        List<String> words = Arrays.asList("GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");
        Optional<String> longestString = words.stream()
                .reduce((word1, word2)
                        -> word1.length() > word2.length()
                        ? word1 : word2);

        System.out.println("longestString = " + longestString);

        Stream<String> wordsq = Stream.of("All", "men", "are", "created", "equal");
        Integer lengthOfAllWords = wordsq.reduce(0, (total, word) -> total + word.length(),
                Integer::sum);
        System.out.println("lengthOfAllWords = " + lengthOfAllWords);

        Set<Integer> collectss = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).skip(3).collect(Collectors.toSet());

        System.out.println("collectss = " + collectss);

        Stream.of(9, 3, 1, 7, 2, 4, 8, 6).sorted().forEach(System.out::println);

        Double collectd= list.stream().collect(Collectors.averagingInt(Employee::getAge));
        System.out.println("collectd = " + collectd);

        Long collecdft = list.stream().collect(Collectors.counting());
        System.out.println("collecdft = " + collecdft);

        Map<String, List<Employee>> collectdc =
                list.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println("collectdc = " + collectdc);
    }
    
    public static class Employee {
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return age == employee.age &&
                    Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

   
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        int age;
        
    }
}
