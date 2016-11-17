import javax.swing.*;

public class PrimeNumbers {
    JList<String> primesList;
    JSpinner toValue;
    JButton findAllPrimes;
    JSpinner fromValue;
    JPanel mainPanel;
    // Список простых чисел
    DefaultListModel<String> primes;
    private JList list1;

    public PrimeNumbers() {
        SpinnerNumberModel fromValueModel =
                new SpinnerNumberModel(2000000000, 1, Integer.MAX_VALUE, 1);
        fromValue.setModel(fromValueModel);

        SpinnerNumberModel toValueModel =
                new SpinnerNumberModel(2100000000, 1, Integer.MAX_VALUE, 1);
        toValue.setModel(toValueModel);

        // Список чисел:
        // 1. Создаем список специального вида - модель данных для отображения в JList
        primes = new DefaultListModel<>();
        // 2. Назначаем "нашему" JList эту модель для отображения
        primesList.setModel(primes);
        // Можно показывать те же данные в другом списке
        list1.setModel(primes);

        // Добавляем обработчик нажания к кнопке
        findAllPrimes.addActionListener(actionEvent -> new Thread(() ->
        {
            // Получаем границу интервала "от" из интерфейса
            int from = fromValueModel.getNumber().intValue();
            int to = toValueModel.getNumber().intValue();

            System.out.println("Поиск простых чисел в диапазоне " + from + "..." + to);

            for (int p = from; p <= to; p++) {
                if (isPrime(p)) {
                    showPrimeNumber(p);
                }
            }
        }).start());
    }

    public static void main(String[] args) {
        // Создаём форму
        JFrame frame = new JFrame("Поиск простых чисел");
        // Задаём содержимое формы
        frame.setContentPane(new PrimeNumbers().mainPanel);
        // Выравниваем компоненты
        frame.pack();
        // При закрытии окна закрываем и программу,
        // иначе она останется висеть в процессах
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Показываем форму
        frame.setVisible(true);
    }

    void showPrimeNumber(int prime) {
        SwingUtilities.invokeLater(() -> {
            // Действия между событиями Swing
            primes.addElement(Integer.toString(prime));
        });
    }

    /**
     * @param p целое число
     * @return является ли простым?
     */
    boolean isPrime(int p) {
        if (p <= 1)
            return false;
        if (p == 2)
            return true;
        for (int i = 3; i * i <= p; i += 2)
            if (p % i == 0) return false;
        return true;
    }
}
