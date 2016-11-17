import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Сравнение списков:
 * Vector и CopyOnWriteArrayList
 */
public class Vector_vs_CopyOnWriteArrayList extends Assert {

    /**
     * Базовые операции с Vector
     */
    @Test
    public void testBaseVector() {
        Vector<Integer> vector = new Vector<>();
        assertEquals("В списке элементов нет", 0, vector.size());
        assertEquals("Но память уже выделена под элементы", 10, vector.capacity());
        // Добавим 10 элементов
        for (int i = 1; i <= 10; i++)
            vector.add(i);
        assertEquals(10, vector.size());
        assertEquals(10, vector.capacity());
        // Проверяем значения
        assertEquals(1, vector.get(0).intValue());
        assertEquals(2, vector.get(1).intValue());
        assertEquals(3, vector.get(2).intValue());
        for (int i = 1; i <= 10; i++)
            assertEquals(i, vector.get(i - 1).intValue());

        // Добавление заданного элемента в заданную позицию
        vector.add(1, 10);
        assertEquals(11, vector.size());
        assertEquals(20, vector.capacity());
    }

    @Test
    public void testBaseCopyOnWriteArrayList() {
        CopyOnWriteArrayList<Integer> ints = new CopyOnWriteArrayList<>();
        // Метода capacity() нет
        assertEquals("В списке элементов нет", 0, ints.size());
        // Добавим 10 элементов
        for (int i = 1; i <= 10; i++)
            ints.add(i);
        assertEquals(10, ints.size());
        // Проверяем значения
        assertEquals(1, ints.get(0).intValue());
        assertEquals(2, ints.get(1).intValue());
        assertEquals(3, ints.get(2).intValue());
        for (int i = 1; i <= 10; i++)
            assertEquals(i, ints.get(i - 1).intValue());

        // Добавление заданного элемента в заданную позицию
        ints.add(1, 10);
        assertEquals(11, ints.size());
    }

    /**
     * Тест с основной операцией - чтение
     *
     * @param list тестируемый список
     */
    private void readTest(List<Integer> list) {
        final int N = 20000;
        // Всего добавлений: N -> 20000
        // Всего чтений:  N*N/2 -> 200000000
        // Добавляем много элементов
        for (int t = 0; t < N; t++) {
            // Добавляем очередной элемент в список
            list.add(t);
            // Читаем (проверяем) все элементы
            for (int i = 0; i < list.size(); i++)
                assertEquals(i, list.get(i).intValue());
        }
    }

    /**
     * Основная операция - чтение: Vector
     * CopyOnWriteArrayList быстрее чем Vector
     * потому что Vector использует синхронизацию при каждой операции
     * (в том числе при get())
     * CopyOnWriteArrayList: 2.5 секунды
     * Vector: 10 секунд
     */
    @Test
    public void testReadVector() {
        readTest(new Vector<>());
    }

    /**
     * Основная операция - чтение: CopyOnWriteArrayList
     */
    @Test
    public void testReadCopyOnWriteArrayList() {
        readTest(new CopyOnWriteArrayList<>());
    }

    /**
     * Основная операция - чтение: CopyOnWriteArrayList
     */
    @Test
    public void testReadSyncArrayList() {
        readTest(Collections.synchronizedList(
                new ArrayList<Integer>()));
    }

    /**
     * Тестирование скорости записи (добавления элемента)
     * Основная операция: add
     *
     * @param list тестируемый список
     */
    private void writeTest(List<Integer> list) {
        for (int t = 0; t < 60000; t++) {
            // Добавляем элемент в список
            list.add(t);
            // LinkedList<T>   [] ->  <-[]->  <-[]
            // Читаем для проверки только 1 элемент
            //assertEquals(t, list.get(t).intValue());
        }
    }

    /**
     * Основная операция - запись: Vector
     * Vector быстрее чем CopyOnWriteArrayList
     * потому что CopyOnWriteArrayList делает копию при добавлении элемента
     * Vector: 0.002 секунды
     * CopyOnWriteArrayList: 2 секунды
     */
    @Test
    public void testWriteVector() {
        writeTest(new Vector<>());
    }

    /**
     * Основная операция - запись: CopyOnWriteArrayList
     */
    @Test
    public void testWriteCopyOnWriteArrayList() {
        writeTest(new CopyOnWriteArrayList<>());
    }

    /**
     * Основная операция - запись
     */
    @Test
    public void testWriteSyncArrayList() {
        writeTest(Collections.synchronizedList(
                new ArrayList<>()));
    }
}
