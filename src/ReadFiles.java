import java.io.*;
import java.util.Arrays;

public class ReadFiles {
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    String[] array1;
    String[] array2;

    public ReadFiles() {}

    public ReadFiles(String fileName1, String fileName2) {                          //Считываю 2 файла, получаю массивы типа String
        try (BufferedReader br1 = new BufferedReader(new FileReader(fileName1))) {
            while (br1.ready()) {
                stringBuilder1.append(br1.readLine() + "\n");

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedReader br2 = new BufferedReader(new FileReader(fileName2))) {
            while (br2.ready()) {
                stringBuilder2.append(br2.readLine() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        array1 = stringBuilder1.toString().split("\n");
        array2 = stringBuilder2.toString().split("\n");

        for (int i = 0; i < array1.length; i++) {
            if (array1[i].contains(" ")) {
                System.out.println("Ошибка! Файл " + fileName1 + " содержит пробельную строку. " + array1[i]);
                array1[i] = "";
            }
        }
        for (int i = 0; i < array2.length; i++) {
            if (array2[i].contains(" ")) {
                System.out.println("Ошибка! Файл " + fileName2 + " содержит пробельную строку. " + array2[i]);
                array2[i] = "";
            }
        }
    }

    public ReadFiles(String fileName1) {                                            //Считываю 1 файл, получаю массив типа String
        try (BufferedReader br1 = new BufferedReader(new FileReader(fileName1))) {
            while (br1.ready()) {
                stringBuilder1.append(br1.readLine() + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        array1 = stringBuilder1.toString().split("\n");

        for (int i = 0; i < array1.length; i++) {
            if (array1[i].contains(" ")) {
                System.out.println("Ошибка! Файл " + fileName1 + " содержит пробельную строку. " + array1[i]);
                array1[i] = "";
            }
        }
    }
}
