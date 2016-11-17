import java.util.Arrays;

/**
 * Передача ссылки на метод
 */
public class MethodReference {

    public static void main(String[] args) {
        String[] stringArray = {"Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda"};
        Arrays.sort(stringArray,
                String::compareToIgnoreCase);
    }
}
