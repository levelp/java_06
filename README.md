<!-- doc.py -->
[![Build Status](https://travis-ci.org/levelp/java_06.svg?branch=master)](https://travis-ci.org/levelp/java_06)
[![Coverage Status](https://coveralls.io/repos/github/levelp/java_06/badge.svg?branch=master)](https://coveralls.io/github/levelp/java_06?branch=master)

Технологии Java:
http://docs.oracle.com/javase/8/docs/index.html



﻿PostgreSQL
----------

* http://www.postgresql.org - основной сайт
* http://www.postgresql.org/download/ - для скачивания
* Реально скачиваем с: http://www.enterprisedb.com/products-services-training/pgdownload#windows - выбираем разрядность своей ОС
* Утилита для администрирования: pgAdmin III: http://www.postgresql.org/ftp/pgadmin3/release/v1.20.0/win32/

``` xml
<groupId>com.github.spring-mvc-archetypes</groupId>
<artifactId>spring-mvc-quickstart</artifactId>
<version>1.0.0</version>

```

Пример PostgreSQL + Spring MVC:
https://github.com/levelp/JobSitePostgreSQL

Добавим 10 элементов
Проверяем значения
Добавление заданного элемента в заданную позицию
Метода capacity() нет
Добавим 10 элементов
Проверяем значения
Добавление заданного элемента в заданную позицию
Всего добавлений: N -> 20000
Всего чтений:  N*N/2 -> 200000000
Добавляем много элементов
Добавляем очередной элемент в список
Читаем (проверяем) все элементы
Добавляем элемент в список
LinkedList<T>   [] ->  <-[]->  <-[]
Читаем для проверки только 1 элемент
assertEquals(t, list.get(t).intValue());
[01_JavaLists/src/test/java/Vector_vs_CopyOnWriteArrayList.java](01_JavaLists/src/test/java/Vector_vs_CopyOnWriteArrayList.java)

Первый поток
Длинный цикл
Пауза: 1 секунда
Ввод строчек
[02_Threads/src/main/java/ASimpleThreads.java](02_Threads/src/main/java/ASimpleThreads.java)

Работа с потоками
-----------------
Остановились
[02_Threads/src/main/java/Main.java](02_Threads/src/main/java/Main.java)

Обычный счётчик без синхронизации
Cчётчик с внешним объектом для синхронизации
Экземпляр класса с синхронизацией по this
Специальный класс для реализации счётчиков
Обнуляем значения всех счётчиков
Создаём массив потоков
Поток1       Поток2
counter = 2    Считал 2
Считал 2
2+1 = 3
Записал 3
2+1 = 3
Записал 3
final int N = i + 1;
lock - мьютекс
int value2 = counterLock;
counterLock = value2 + 1;
pause();
Ждём пока все потоки завершатся
Печатаем значение всех счётчиков
MyClass.class
this
[02_Threads/src/main/java/ManyThread.java](02_Threads/src/main/java/ManyThread.java)

String s = Main.strings.remove();
[02_Threads/src/main/java/Thread2.java](02_Threads/src/main/java/Thread2.java)

t2.wait();
[02_Threads/src/main/java/ThreadDebug.java](02_Threads/src/main/java/ThreadDebug.java)

Лямбда-выражения
counter++;
this
[02_Threads/src/main/java/ThreadDemo.java](02_Threads/src/main/java/ThreadDemo.java)

Первый поток
Второй поток
[02_Threads/src/main/java/ThreadDemo2.java](02_Threads/src/main/java/ThreadDemo2.java)

Объект для синхронизации
Первый поток
из памяти i -> R = 0
R++ = 1  (*)
x--- прервали и переключились на поток 2 ---
Второй поток
i -> R = 0
R-- = -1
i <- R    i = -1
x--- возвращаемся в первый поток ---
i  <-  R = 1
i = 1
Запускаем оба потока
Ждём их завершения
Печатаем значение x
[02_Threads/src/main/java/ThreadIncDecDemo.java](02_Threads/src/main/java/ThreadIncDecDemo.java)

JIT -
Когда метод выполняется > 10000 раз, он компилируется в
native-машинный код
Первый поток
из памяти i -> R = 0
R++ = 1  (*)
x--- прервали и переключились на поток 2 ---
Второй поток
i -> R = 0
R-- = -1
i <- R    i = -1
x--- возвращаемся в первый поток ---
i  <-  R = 1
i = 1
Запускаем оба потока
Ждём их завершения
Печатаем значение x
[02_Threads/src/main/java/ThreadIncDecDemo2.java](02_Threads/src/main/java/ThreadIncDecDemo2.java)

private static AtomicInteger x = new AtomicInteger(0);
volatile static int x2 = 0;
Запускаем 2 потока
System.out.println("x changed = " + x);
x.incrementAndGet();
Прерывание своего потока
Thread.currentThread().interrupt();
[02_Threads/src/main/java/VolatileDemo.java](02_Threads/src/main/java/VolatileDemo.java)

Основной начальный поток "main"
[02_Threads/src/main/java/simple/OneThread.java](02_Threads/src/main/java/simple/OneThread.java)

Запуск второго потока
[02_Threads/src/main/java/simple/TwoThreads.java](02_Threads/src/main/java/simple/TwoThreads.java)

Имя текущего потока
[02_Threads/src/main/java/thread_samples/T2.java](02_Threads/src/main/java/thread_samples/T2.java)

Прерываем основной поток приложения
[02_Threads/src/test/java/ThreadsExceptions.java](02_Threads/src/test/java/ThreadsExceptions.java)

Создаём много потоков
Ожидаем пока все потоки завершатся
[02_Threads/src/test/java/VolatileTest.java](02_Threads/src/test/java/VolatileTest.java)

Sleep for a bit so that thread 1 has a chance to start
[02_Threads/src/test/java/vol/ThreadTest.java](02_Threads/src/test/java/vol/ThreadTest.java)

Ждём завершения всех потоков
System.out.println("i=" + li + " j=" + lj);
[02_Threads/src/test/java/vol/Volatile.java](02_Threads/src/test/java/vol/Volatile.java)

atomic (пакет java.util.concurrent.atomic)
------------------------------------------
Классы из пакета java.util.concurrent.atomic обеспечивают
выполнение атомарных операций
``` java
public class AtomicDemo {
    static final Object LOCK = new Object();
    static final AtomicInteger ATOMIC_SUM = new AtomicInteger();
    static final CountDownLatch CDL = new CountDownLatch(100000);
    static int sum = 0;
    static volatile int globalI;
    static int threadCount = 0;

    static {
        AtomicInteger atomicInteger = new AtomicInteger(2);
        AtomicLong atomicLong = new AtomicLong(3232L);
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        // Нет: AtomicByte, AtomicShort, AtomicFloat, AtomicDouble, AtomicString
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1, 3, 4});
        atomicInteger.addAndGet(10);
        atomicBoolean.set(true);
        atomicBoolean.get();
        atomicLong.addAndGet(100000);
        atomicIntegerArray.addAndGet(1, 10);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
        System.out.println("sum = " + sum);
        System.out.println("ATOMIC_SUM = " + ATOMIC_SUM.get());
        System.out.println("globalI = " + globalI);
        System.out.println("wait");
        Thread.sleep(500);
        CDL.await();
        System.out.println("threadCount = " + threadCount);
        System.out.println("sum = " + sum);
        System.out.println("ATOMIC_SUM = " + ATOMIC_SUM.get());
    }

    private static void inc() {
        synchronized (LOCK) {
            sum++;
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            threadCount++;
            for (int i = 0; i < 100; ++i) {
                globalI++;
                inc();
                ATOMIC_SUM.incrementAndGet();
                CDL.countDown();
            }
        }
    }
}
```

[03_Atomic/src/main/java/AtomicDemo.java](03_Atomic/src/main/java/AtomicDemo.java)

1. Загрузить из памяти
2. Поменять значение
3. Записать в память
Подождём оба потока
Какое же значение переменной?
[03_Atomic/src/main/java/SyncThread.java](03_Atomic/src/main/java/SyncThread.java)

1. Загрузить из памяти
2. Поменять значение
3. Записать в память
Подождём оба потока
Какое же значение переменной?
[03_Atomic/src/main/java/SyncThread2.java](03_Atomic/src/main/java/SyncThread2.java)

1. Загрузить из памяти
2. Поменять значение
3. Записать в память
Подождём оба потока
Какое же значение переменной?
[03_Atomic/src/main/java/SyncThread3.java](03_Atomic/src/main/java/SyncThread3.java)

1. Загрузить из памяти
2. Поменять значение
3. Записать в память
Подождём оба потока
Какое же значение переменной?
[03_Atomic/src/main/java/SyncThread4.java](03_Atomic/src/main/java/SyncThread4.java)

1. Загрузить из памяти
2. Поменять значение
3. Записать в память
Подождём оба потока
Какое же значение переменной?
[03_Atomic/src/main/java/SyncThread5.java](03_Atomic/src/main/java/SyncThread5.java)

Страртуем 10000 потоков на increment
Поток пусть поспит случайное время
Подождём теперь завершения всех потоков
Страртуем 10000 потоков на increment
Снова подождём теперь завершения всех потоков
[03_Atomic/src/test/java/SyncronizedTest.java](03_Atomic/src/test/java/SyncronizedTest.java)

Получение несуществующего свойства
InputStream input = new FileInputStream("D:\\a.mydata");
[04_Properties/src/test/java/PropertiesTest.java](04_Properties/src/test/java/PropertiesTest.java)

Недопустимо:
i++;
i = 100;
Недопустимо:
intArray = new int[100];
Недопустимо:
myClass = new MyClass(100);
myClass = null;
VALUE2 - final-поле
myClass.VALUE2 = 30;
x.VALUE2 = 10;
Можем менять значение
param1 = 10;
param2 = "3232";
final-методы невозможно переопределить
@Override
public void m1() {
}
final - не можем создать наследника
final-поля
final - мы можем присваивать значение
только в конструкторе
и только один раз
1. К окончанию любого конструктора все final-поля
должны быть проинициализированы
2. Значение можно присвоить только 1 раз:
до конструктора или в конструкторе
value2 = 10; // Не можем
this.VALUE2 = 10;
Не можем перезагрузить
void x(){
}
[05_Final/src/java/FinalDemo.java](05_Final/src/java/FinalDemo.java)

Создаётся безымянный подкласс
класса Operation
с переопределённым методом
apply(a, b)
Автоматическая проверка контракта
System.out.println(op.name());
Считаем результатом первый аргумент
[06_Java8_Lambda/src/main/java/CalcDemo.java](06_Java8_Lambda/src/main/java/CalcDemo.java)

Автоматическая проверка контракта
System.out.println(op.name());
Считаем результатом первый аргумент
Создаётся безымянный подкласс
класса Operation
с переопределённым методом
apply(a, b)
[06_Java8_Lambda/src/test/java/CalcDemoTest.java](06_Java8_Lambda/src/test/java/CalcDemoTest.java)

6
5    1
4  3  8
2
Операция с деревом
Конструктор
Вызов другого конструктора
[06_Java8_Lambda/src/test/java/TreeTest.java](06_Java8_Lambda/src/test/java/TreeTest.java)

﻿Домашнее задание
----------------
* Сохранение в файл и загрузка объекта из файла
** object.txt **
```
MyClass
str: Строчка
i: 23
d: 1.2
b: true
```
* Дополнить в FileStorage реализацию методов save/load.
* Дополнить реализацию FileStorage методами delete, update, getList.
* Загрузить и настроить Tomcat.
**tomcat\conf\tomcat-users.xml**

``` xml
  <role rolename="manager-gui"/>
  <user username="admin" password="123" roles="manager-gui"/>
```
* Изучить примеры к Tomcat
  * tomcat\webapps\examples\jsp\jsp2\el\composite.jsp - путь к примеру в папке.
  * http://localhost:8080/examples/jsp/jsp2/el/composite.jsp - путь к примеру в браузере.




Литература
----------
* JMM
* Java Concurrency in Practice - http://www.amazon.com/Java-Concurrency-Practice-Brian-Goetz/dp/0321349601
* JDK concurrent package
* Обзор java.util.concurrent.
* Синхронизация потоков

Список простых чисел
Список чисел:
1. Создаем список специального вида - модель данных для отображения в JList
2. Назначаем "нашему" JList эту модель для отображения
Можно показывать те же данные в другом списке
Добавляем обработчик нажания к кнопке
Получаем границу интервала "от" из интерфейса
Создаём форму
Задаём содержимое формы
Выравниваем компоненты
При закрытии окна закрываем и программу,
иначе она останется висеть в процессах
Показываем форму
Действия между событиями Swing
[HomeWork/src/main/java/PrimeNumbers.java](HomeWork/src/main/java/PrimeNumbers.java)

Автоматическая проверка контракта
[LambdaDemo/src/main/java/CalcDemo.java](LambdaDemo/src/main/java/CalcDemo.java)


