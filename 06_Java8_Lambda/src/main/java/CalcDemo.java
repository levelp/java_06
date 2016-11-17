/**
 * Пример вычислений с ипользованием лямбда-выражений
 */
public class CalcDemo {

    public static void main(String[] args) {
        Operation sum = (a, b) -> a + b;
        System.out.println(sum.name());
        System.out.println("sum = " +
                map(sum, 1.2, 3.4, 4.5, 10.0)
        );
        // Создаётся безымянный подкласс
        // класса Operation
        // с переопределённым методом
        // apply(a, b)
        System.out.println("Умножить = " +
                map((a, b) -> a * b, 2, 3, 4)
        );
        System.out.println("map() = " +
                map(CalcDemo::sumNum, 10, 23.2)
        );
        System.out.println("map() = " +
                map(CalcDemo::sumNum, 111)
        );
    }

    public static double sumNum(double a, double b) {
        return a + b;
    }

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
}
