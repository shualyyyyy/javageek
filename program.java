package task;

// import java.io.FileWriter;
// import java.io.IOException;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

public class program{
        public static void main(String[] args) {
         try{
            // Запрос данных у пользователя
            Scanner scan = new Scanner(System.in);
            System.out.println("Напишите своё фамилию: ");
            String Surname = scan.nextLine();
            System.out.println("Напишите своё имя: ");
            String name = scan.nextLine();
            System.out.println("Напишите ваше отчество: ");
            String fatherName = scan.nextLine();
            System.out.println("Напишите вашу дату рождения(dd.mm.yyyy): ");
            String born = scan.nextLine();
            System.out.println("Напишите свой номер телефон(беззнаковое число без форматирования): ");
            String phone = scan.nextLine();
            System.out.println("Укажите пол(f/m): ");
            String gender = scan.nextLine();
            scan.close();
            String input = Surname +" " + name +" " + fatherName + " " + born + " " + phone + " " + gender;
            String[] data = input.split(" ");

            // Проверка количества данных
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            // Проверка формата данных
            if (!born.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }
            if (!phone.matches("\\d+")) {
                throw new IllegalArgumentException("Неверный формат номера телефона");
            }
            if (!gender.matches("[mf]")) {
                throw new IllegalArgumentException("Неверный формат пола");
            }

            // Создание файла и запись данных
            String filename = Surname + ".txt";
            try (FileWriter writer = new FileWriter(filename, true)) {
                writer.write(input);
            }

            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

