import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WriteFilesString {                                                                  //Сортировка и запись строковых массивов в выходной файл
    public WriteFilesString() {}

    public void WriteFilesStringUp(String outFileName, String[] array1, String[] array2) {      //Сортировка по возрастанию двух файлов
        SortArrayString sortArrayString = new SortArrayString();
        Arrays.sort(array1);                                                                    //Сортирую массивы
        Arrays.sort(array2);
        String[] sortArray = sortArrayString.sortArrayString(array1, array2);                   //Сортировка слиянием двух массивов
        try (FileWriter writer = new FileWriter(outFileName)) {                                 //Запись массива в файл
            for (int i = 0; i < sortArray.length; i++) {
                writer.write(sortArray[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Укажите имя выходного файла (out.txt).");
        }
    }

    public void WriteFilesStringUp(String outFileName, String[] array1) {                       //Сортировка, если один входной файл
        SortArrayString sortArrayString = new SortArrayString();
        Arrays.sort(array1);
        String[] sortArray = sortArrayString.sortArrayString(array1, new String[]{});
        try (FileWriter writer = new FileWriter(outFileName)) {
            for (int i = 0; i < sortArray.length; i++) {
                writer.write(sortArray[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void WriteFilesStringDown(String outFileName, String[] array1, String[] array2) {     //Сортировка в обратном порядке 1 фходного файла
        SortArrayString sortArrayString = new SortArrayString();
        Arrays.sort(array1);
        Arrays.sort(array2);
        String[] sortArray = sortArrayString.sortArrayStringDown(array1, array2);
        sortArray = sortArrayString.reverse(sortArray);
        try (FileWriter writer = new FileWriter(outFileName)) {
            for (int i = 0; i < sortArray.length; i++) {
                writer.write(sortArray[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Укажите имя выходного файла (out.txt).");
        }
    }

    public void WriteFilesStringDown(String outFileName, String[] array1) {                        //Сортировка в обратном порядке 1 фходного файла
        SortArrayString sortArrayString = new SortArrayString();
        Arrays.sort(array1);
        String[] sortArray = sortArrayString.sortArrayString(array1, new String[]{});
        sortArray = sortArrayString.reverse(sortArray);
        try (FileWriter writer = new FileWriter(outFileName)) {
            for (int i = 0; i < sortArray.length; i++) {
                writer.write(sortArray[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Укажите имя выходного файла (out.txt).");
        }
    }
}
