/**
 * Разделяемый класс
 */
class SharedClass {
    synchronized void increment() {
        Main.globalVar++;
    }
}
