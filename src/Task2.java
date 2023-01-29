import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(32);
        list.add(82);
        list.add(11);
        list.add(99);
        list.add(48);
        list.add(11);
        list.add(77);
        list.add(40);

        Stream<Integer> listStream = list.stream();
        long count = listStream
                .filter(i -> i % 2 == 0)
                .count();
        System.out.println("Количество четных чисел " + count);
    }
}

