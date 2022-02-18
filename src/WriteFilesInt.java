import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WriteFilesInt {                                                                    //Сортировка и запись числовых массивов в выходной файл
    int[] newArray1;
    int[] newArray2;

    public WriteFilesInt() {}

    public void WriteFilesIntUp (String outFileName, String[] array1, String[] array2) {        //Сортировка по возрастанию двух файлов
        Convert convert1 = new Convert(array1);                                                 //Конвертирую массив String[] в int[]
        Convert convert2 = new Convert(array2);
        newArray1 = convert1.convertArray(array1);
        newArray2 = convert2.convertArray(array2);

        Arrays.sort(newArray1);                                                                 //Сортирую массивы по возрастанию
        Arrays.sort(newArray2);

        SortArrayInt sortArrayInt = new SortArrayInt();
        int[] sortArray = sortArrayInt.sortArrayInt(newArray1, newArray2);                      //Сортировка слиянием двух массивов

        try (FileWriter writer = new FileWriter(outFileName)) {                                 //Запись массива в файл
            for (int i = 0; i < sortArray.length; i++) {
                writer.write(sortArray[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Укажите имя выходного файла (out.txt).");
        }
    }

    public void WriteFilesIntUp (String outFileName, String[] array1) {                         //Сортировка, если один входной файл
        Convert convert1 = new Convert(array1);                                                 //Аналогично предыдущему методу
        newArray1 = convert1.convertArray(array1);

        Arrays.sort(newArray1);
        SortArrayInt sortArrayInt = new SortArrayInt();
        int[] sortArray = sortArrayInt.sortArrayInt(newArray1, new int[]{});

        try (FileWriter writer = new FileWriter(outFileName)) {
            for (int i = 0; i < sortArray.length; i++) {
                writer.write(sortArray[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Укажите имя выходного файла (out.txt).");
        }
    }

    public void WriteFilesIntDown (String outFileName, String[] array1, String[] array2) {         //Сортировка в обратном порядке
        Convert convert1 = new Convert(array1);
        Convert convert2 = new Convert(array2);
        newArray1 = convert1.convertArray(array1);
        newArray2 = convert2.convertArray(array2);

        Arrays.sort(newArray1);
        Arrays.sort(newArray2);
        SortArrayInt sortArrayInt = new SortArrayInt();
        int[] sortArray = sortArrayInt.sortArrayIntDown(newArray1, newArray2);

        try (FileWriter writer = new FileWriter(outFileName)) {
            for (int i = 0; i < sortArray.length; i++) {
                writer.write(sortArray[i] + "\n");
            }
        }catch (IOException e) {
            System.out.println("Укажите имя выходного файла (out.txt).");
        }
    }

    public void WriteFilesIntDown (String outFileName, String[] array1) {                           //Сортировка в обратном порядке 1 фходного файла
        Convert convert1 = new Convert(array1);
        newArray1 = convert1.convertArray(array1);

        Arrays.sort(newArray1);
        SortArrayInt sortArrayInt = new SortArrayInt();
        int[] sortArray = sortArrayInt.sortArrayInt(newArray1, new int[]{});
        sortArray = sortArrayInt.reverse(sortArray);
        try (FileWriter writer = new FileWriter(outFileName)) {
            for (int i = 0; i < sortArray.length; i++) {
                writer.write(sortArray[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Укажите имя выходного файла (out.txt).");
        }
    }
}
