import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода данных
        Scanner scanner = new Scanner (System.in, "Cp866");
        // Вводим имя с клавиатуры
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        // Проверяем условие: если введенное имя Вячеслав, выводим "Привет, Вячеслав"
        // если нет, выводим "Нет такого имени"
        System.out.println(name);
        if (name.equals("Вячеслав")) {
            System.out.println("Привет, Вячеслав");
        }
        else System.out.println("Нет такого имени");

        // Закрываем Scanner
        scanner.close();
    }
}