import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class GeneratingSeriesJ8B {

    static IntUnaryOperator fibonacci;

    public static void main(String[] args) {
        System.out.printf("%nПервые 10 чисел Фибоначчи:%n");
        IntStream.range(0, 11)
                .map(fibonacci = i -> i <= 1
                        ? 1
                        : fibonacci.applyAsInt(i - 2) + fibonacci.applyAsInt(i - 1))
                .parallel()
                .forEachOrdered(e -> System.out.printf("%s ", e));
    }
}