import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(43);
        list.add(74);
        list.add(31);
        Stream<Integer> streamList = list.stream();
        findMinMax(streamList, Comparator.comparingInt(i -> i), (minX, maxX) -> System.out.println("Минимальное - " + minX + ", Максимальное - " + maxX));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        List<T> arrayList = new ArrayList<>();
        T min = null;
        T max = null;
        arrayList = stream.sorted(order).collect(Collectors.toList());
        if (arrayList.size() > 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }
}

