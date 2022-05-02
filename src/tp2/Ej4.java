package tp2;

public class Ej4 {
    public static void main(String[] args) {
        Ej4 ej4 = new Ej4();
        int[] array1 = { 4, 3, 2, 15, 8 };

        ej4.bubbleSort(array1);
    }

    public void selectionSort(int[] array) {

    }

    public void bubbleSort(int[] array) {
        int aux;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;
                }
            }

        }
    }

}
