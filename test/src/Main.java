import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода данных
        Scanner scanner = new Scanner(System.in);

        // Вводим число с клавиатуры
        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        // Проверяем условие: если введенное число больше 7, выводим "Привет"
        if (number > 7) {
            System.out.println("Привет");
        }
        else System.out.println("Пока");

        // Закрываем Scanner
        scanner.close();
    }
}