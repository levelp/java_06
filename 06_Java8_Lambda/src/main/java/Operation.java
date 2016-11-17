/**
 * Произвольная бинарная операция с 2-мя double
 */
public interface Operation {
    double apply(double a, double b);

    default String name() {
        return "Операция";
    }
}
