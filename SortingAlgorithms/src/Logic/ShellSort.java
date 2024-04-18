package Logic;
    public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                    imprimirMovimiento(arr); // Imprimir cada movimiento
                }
                arr[j] = key;
                imprimirMovimiento(arr); // Imprimir cada movimiento
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {11,9,74, 2, 3};

        System.out.println("Arreglo original:");
        imprimirArreglo(numeros);

        shellSort(numeros);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(numeros);
    }

    public static void imprimirMovimiento(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
