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

