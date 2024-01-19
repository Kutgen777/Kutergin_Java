import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода данных
        Scanner scanner = new Scanner(System.in);

        // Вводим размер массива с клавиатуры
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        // Создаем массив указанного размера
        int[] numbers = new int[size];

        // Вводим элементы массива с клавиатуры
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Выводим элементы массива, кратные 3
        System.out.println("Элементы массива, кратные 3:");
        for (int i = 0; i < size; i++) {
            if (numbers[i] % 3 == 0) {
                System.out.println(numbers[i]);
            }
        }

        // Закрываем Scanner
        scanner.close();
    }
}