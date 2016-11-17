import org.junit.Assert;
import org.junit.Test;

/**
 * Пример вычислений с ипользованием лямбда-выражений
 */
public class CalcDemoTest extends Assert {
    /**
     * @param op  Пользовательская операция
     * @param arg Массив значений, количество значений больше нуля
     * @return результат применения операции к массиву значений
     */
    static double map(Operation op,
                      double... arg) {
        // Автоматическая проверка контракта
        assert arg.length > 0;
        //System.out.println(op.name());
        // Считаем результатом первый аргумент
        double res = arg[0];
        for (int i = 1; i < arg.length; ++i)
            res = op.apply(res, arg[i]);
        return res;
    }

    @Test
    public void testSum() {
        Operation sum = (a, b) -> a + b;
        assertEquals("Операция", sum.name());
        assertEquals(1.0 + 2.0, map(sum, 1.0, 2.0), 1e-10);
        // Создаётся безымянный подкласс
        // класса Operation
        // с переопределённым методом
        // apply(a, b)
        assertEquals(2 * 3 * 4, map((a, b) -> a * b, 2, 3, 4), 1e-10);
        assertEquals(33.2, map(CalcDemo::sumNum, 10, 23.2), 1e-10);
        assertEquals(111, map(CalcDemo::sumNum, 111), 1e-10);
    }
}
