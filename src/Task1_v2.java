import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1_v2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(43);
        list.add(74);
        list.add(31);
        Stream<Integer> streamList = list.stream();
        findMinMax(streamList, Comparator.comparingInt(i -> i), (min, max) -> System.out.println("Минимальное - " + min + ", Максимальное - " + max));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        List<T> arrayList;
        T min = null;
        T max = null;

        arrayList = stream.collect(Collectors.toList());

        Optional<T> minX = arrayList.stream().min(order);
        Optional<T> maxX = arrayList.stream().max(order);

        if (arrayList.size() > 0) {
            min = minX.get();
            max = maxX.get();
        }
        minMaxConsumer.accept(min, max);
    }
}
