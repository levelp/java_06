/**
 * final:
 * - локальные переменные + параметры метода
 * Присваивать значение только один раз
 * - поля класса
 * - методы класса
 * - классы
 */
public class FinalDemo {
    public static MyClass x;

    public static void main(String[] args) {
        final int i = 10;
        // Недопустимо:
        // i++;
        // i = 100;
        final int[] intArray = {1, 2};
        // Недопустимо:
        // intArray = new int[100];
        intArray[0]++;
        intArray[1]++;

        final MyClass myClass = new MyClass(10);
        // Недопустимо:
        // myClass = new MyClass(100);
        // myClass = null;
        // VALUE2 - final-поле
        // myClass.VALUE2 = 30;
        // x.VALUE2 = 10;
        // Можем менять значение
        myClass.value = 1;
        myClass.value = 20;
        System.out.println("myClass.value = " + myClass.value);
    }

    void method(final int param1, final String param2, final MyClass param3) {
        //param1 = 10;
        //param2 = "3232";
    }

    static class A {
        // final-методы невозможно переопределить
        public final void m1() {
        }
    }

    static class B extends A {
        //@Override
        //public void m1() {
        //}
    }

    // final - не можем создать наследника
    static final class MyClass {
        // final-поля
        // final - мы можем присваивать значение
        // только в конструкторе
        // и только один раз
        // 1. К окончанию любого конструктора все final-поля
        // должны быть проинициализированы
        // 2. Значение можно присвоить только 1 раз:
        //  до конструктора или в конструкторе
        final int VALUE2; // = 10;
        int value;

        MyClass(final int value2) {
            // value2 = 10; // Не можем
            x = this;
            // this.VALUE2 = 10;
            this.VALUE2 = value2 + 100;
        }
    }

    static class AA {
        final void x() {

        }
    }

    static class BB extends AA {
        // Не можем перезагрузить
        //void x(){
        //}
        int x(int x) {
            return 0;
        }

        double x(double xx) {
            return 0.0;
        }
    }

/*
    static class MyClass2 extends MyClass {

        public MyClass2(int value2) {
            super(value2);
        }
    }
*/
}
