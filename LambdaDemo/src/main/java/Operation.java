/**
 *
 */
public interface Operation {
    double apply(double a, double b);

    default String name() {
        return "Операция";
    }
}
