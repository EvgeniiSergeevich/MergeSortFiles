public class SortArrayString {                                                              //Сортировка слиянием массивов String
    public String[] sortArrayString (String[] array1, String[] array2) {                    //Сортировка слиянием массивов String по возрастанию
        int i = 0, j = 0, k =0;
        String[] result = new String[array1.length + array2.length];
        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[j]) < 0) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }
        if (i == array1.length) {
            while (j < array2.length) {
                result[k] = array2[j];
                j++; k++;
            }
        }
        if (j == array2.length) {
            while (i < array1.length) {
                result[k] = array1[i];
                i++; k++;
            }
        }

        return result;
    }

    public String[] sortArrayStringDown (String[] array1, String[] array2) {                //Сортировка слиянием массивов String по убыванию
        int i = 0, j = 0, k =0;

        String[] result = new String[array1.length + array2.length];
        if (array1[0].compareTo(array1[array1.length - 1]) < 0) {                           //Если массив из первого файла отсортирован по возрастанию
            array1 = reverse(array1);                                                       //разворачиваю его
        }

        if (array2[0].compareTo(array2[array2.length - 1]) < 0) {                           //Если массив из второго файла отсортирован по возрастанию
            array2 = reverse(array2);                                                       //разворачиваю его
        }

        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[j]) > 0) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }
        if (i == array1.length) {
            while (j < array2.length) {
                result[k] = array2[j];
                j++; k++;
            }
        }
        if (j == array2.length) {
            while (i < array1.length) {
                result[k] = array1[i];
                i++; k++;
            }
        }

        return result;
    }

    public String[] reverse (String[] array) {                                                  //Метод, разворачивающий массив
        String[] result = new String[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[result.length - 1 - i];
        }
        return result;
    }
}
