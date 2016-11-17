import org.junit.Assert;
import org.junit.Test;

import java.util.function.UnaryOperator;

/**
 * Рекурсивные лямбда-выражения
 */
public class RecursiveLambda extends Assert {
    UnaryOperator<Integer> factorial;

    @Test
    public void testX() {
        factorial = i -> i == 0 ? 1 : i * factorial.apply(i - 1);
    }
}
