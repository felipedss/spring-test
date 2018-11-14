package br.com.projuris;

public class MyFindArray implements FindArray {

    @Override
    public int findArray(int[] array, int[] subArray) {
        int MAX_POSITION_FIRST_ARRAY = array.length - 1;
        int MAX_POSITION_SECOND_ARRAY = subArray.length - 1;

        for (int i = MAX_POSITION_FIRST_ARRAY; i >= 0; i--) {

            boolean contains = true;
            for (int j = 0; j < subArray.length && j <= i; j++) {
                if (array[i - j] != subArray[MAX_POSITION_SECOND_ARRAY - j]) {
                    contains = false;
                    break;
                }
            }
            if (contains) {
                return i - MAX_POSITION_SECOND_ARRAY;
            }
        }

        return -1;
    }

}
