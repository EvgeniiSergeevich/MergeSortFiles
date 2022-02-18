import java.util.ArrayList;

public class MergeSort {
    static ArrayList<String> namesFiles = new ArrayList<>();
    static String fileOut = "";
    static String params = "";


    public static void main(String[] args) {
        ReadFiles readFiles = new ReadFiles();
        WriteFilesInt writeFilesInt = new WriteFilesInt();
        WriteFilesString writeFilesString = new WriteFilesString();

        for (String str : args) {                           //Проверяю, указаны ли текстовые файлы в параметрах запуска
            if (str.endsWith(".txt")) {                     //добавляю в список
                namesFiles.add(str);
            } else if (str.startsWith("-")) {               //Добавляю в строку параметры запуска (-i, -s, -d, -a)
                params = params + str;
            }
        }

        for (int i = 0; i < namesFiles.size(); i++) {       //Сохраняю имя выходного файла отдельно и удаляю из списка
            if (namesFiles.get(i).startsWith("out")) {
                fileOut = namesFiles.get(i);
                namesFiles.remove(fileOut);
            }
        }

        if (params.equals("-s-a") || params.equals("-s") || params.equals("-a-s")) {                    //Если указан параметр -s и -a(не обязательно)
            if (namesFiles.size() < 2) {                                                                //Если 0 или 1 входной файл
                readFiles = new ReadFiles(namesFiles.get(0));
                writeFilesString.WriteFilesStringUp(fileOut, readFiles.array1);
            } else {                                                                                    //Если входных файлов несколько
                readFiles = new ReadFiles(namesFiles.get(0), namesFiles.get(1));
                writeFilesString.WriteFilesStringUp(fileOut, readFiles.array1, readFiles.array2);
                for (int i = 2; i < namesFiles.size(); i++) {
                    readFiles = new ReadFiles(fileOut, namesFiles.get(i));
                    writeFilesString.WriteFilesStringUp(fileOut, readFiles.array1, readFiles.array2);
                }
            }
        } else if (params.equals("-i-a") || params.equals("-i") || params.equals("-a-i")) {             //Если указан параметр -i и -a(не обязательно)
            if (namesFiles.size() < 2) {
                readFiles = new ReadFiles(namesFiles.get(0));
                writeFilesInt.WriteFilesIntUp(fileOut, readFiles.array1);
            } else {
                readFiles = new ReadFiles(namesFiles.get(0), namesFiles.get(1));
                writeFilesInt.WriteFilesIntUp(fileOut, readFiles.array1, readFiles.array2);
                for (int i = 2; i < namesFiles.size(); i++) {
                    readFiles = new ReadFiles(fileOut, namesFiles.get(i));
                    writeFilesInt.WriteFilesIntUp(fileOut, readFiles.array1, readFiles.array2);
                }
            }
        } else if (params.equals("-s-d") || params.equals("-d-s")) {                                    //Если указан параметр -s и -d
            if (namesFiles.size() < 2) {
                readFiles = new ReadFiles(namesFiles.get(0));
                writeFilesString.WriteFilesStringDown(fileOut, readFiles.array1);
            } else {
                readFiles = new ReadFiles(namesFiles.get(0), namesFiles.get(1));
                writeFilesString.WriteFilesStringDown(fileOut, readFiles.array1, readFiles.array2);
                for (int i = 2; i < namesFiles.size(); i++) {
                    readFiles = new ReadFiles(fileOut, namesFiles.get(i));
                    writeFilesString.WriteFilesStringDown(fileOut, readFiles.array1, readFiles.array2);
                }
            }
        } else if (params.equals("-i-d") || params.equals("-d-i")) {                                    //Если указан параметр -i и -d
            if (namesFiles.size() < 2) {
                readFiles = new ReadFiles(namesFiles.get(0));
                writeFilesInt.WriteFilesIntDown(fileOut, readFiles.array1);
            } else {
                readFiles = new ReadFiles(namesFiles.get(0), namesFiles.get(1));
                writeFilesInt.WriteFilesIntDown(fileOut, readFiles.array1, readFiles.array2);
                for (int i = 2; i < namesFiles.size(); i++) {
                    readFiles = new ReadFiles(fileOut, namesFiles.get(i));
                    writeFilesInt.WriteFilesIntDown(fileOut, readFiles.array1, readFiles.array2);
                }
            }
        } else {                                                                                        //Если указаны не верные параметры (отсутствует -i или -s)
            System.out.println("""
                    Некорректно введены параметры!
                    Укажите режим сортировки (-a по возрастанию или -d по убыванию), по умолчанию -a;
                    Укажите тип данных (-s - String или -i - int);""");
        }
    }
}
