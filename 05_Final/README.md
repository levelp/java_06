<!-- doc.py -->
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
[src/java/FinalDemo.java](src/java/FinalDemo.java)

