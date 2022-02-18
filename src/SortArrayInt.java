import java.util.Arrays;

public class SortArrayInt { //Сортировка слиянием массивов int
    public int[] sortArrayInt (int[] intArray1, int[] intArray2) {                                  //Сортировка слиянием массивов int по возрастанию
        int i = 0, j = 0, k = 0;
        int [] result = new int[intArray1.length + intArray2.length];
        while (i < intArray1.length && j < intArray2.length) {
            if (intArray1[i] < intArray2[j]) {
                result[k] = intArray1[i];
                i++;
            } else {
                result[k] = intArray2[j];
                j++;
            }
            k++;
        }
        if (i == intArray1.length) {
            while (j < intArray2.length) {
                result[k] = intArray2[j];
                j++; k++;
            }
        }
        if (j == intArray2.length) {
            while (i < intArray1.length) {
                result[k] = intArray1[i];
                i++; k++;
            }
        }
        return result;
    }

    public int[] sortArrayIntDown (int[] intArray1, int[] intArray2) {                              //Сортировка слиянием массивов int по убыванию
        int i = 0, j = 0, k = 0;
        int [] result = new int[intArray1.length + intArray2.length];

        if (intArray1[0] < intArray1[intArray1.length - 1]) {
            intArray1 = reverse(intArray1);
        }

        if (intArray2[0] < intArray2[intArray2.length - 1]) {
            intArray2 = reverse(intArray2);
        }
        while (i < intArray1.length && j < intArray2.length) {
            if (intArray1[i] > intArray2[j]) {
                result[k] = intArray1[i];
                i++;
            } else {
                result[k] = intArray2[j];
                j++;
            }
            k++;
        }
        if (i == intArray1.length) {
            while (j < intArray2.length) {
                result[k] = intArray2[j];
                j++; k++;
            }
        }
        if (j == intArray2.length) {
            while (i < intArray1.length) {
                result[k] = intArray1[i];
                i++; k++;
            }
        }
        return result;
    }

    public int[] reverse (int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[result.length - 1 - i];
        }
        return result;
    }
}
