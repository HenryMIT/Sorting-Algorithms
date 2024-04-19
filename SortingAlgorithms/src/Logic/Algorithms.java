/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Algorithms {

    //Atribute
    int[] listNumber = new int[100000];

    public Algorithms() {
        //Fill the vector with numbers from 1 to 100000
        fillArray();
    }

    public void fillArray() {
        Random randon = new Random();
        for (int i = 0; i < this.listNumber.length; i++) {
            this.listNumber[i] = randon.nextInt(100000);
        }
    }

    public void printList() {
        int n = listNumber.length;
        System.out.println("List Number {");
        for (int i = 0; i < n; i++) {
            String ln = i % 20 == 0 ? ", \n" : " , ";
            System.out.print(listNumber[i] + ln);
        }
        System.out.println("}");
    }

    //Basic algorithm
    public void BubbleSort() {
        int temp = 0;
        int n = listNumber.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < (n - i - 1); j++) {
                // Compares the numbers in the array and orders them
                if (listNumber[j] > listNumber[j + 1]) {
                    //Exchange listNumber[j] with listNumber[j+1]
                    temp = listNumber[j];
                    listNumber[j] = listNumber[j + 1];
                    listNumber[j + 1] = temp;
                }
            }
        }
    }

    //Unstable algorithms
    public void shell() {
        createRandomArray();

        int jump, i, j, k, auxiliar;
        jump = listNumber.length / 2;
        while (jump > 0) {
            for (i = jump; i < listNumber.length; i++) {
                j = i - jump;
                while (j >= 0) {
                    k = j + jump;
                    if (listNumber[j] <= listNumber[k]) {
                        j = -1;
                    } else {
                        auxiliar = listNumber[j];
                        listNumber[j] = listNumber[k];
                        listNumber[k] = auxiliar;
                        j -= jump;
                    }
                }

            }
            jump = jump / 2;
        }
        System.out.println("Sort Array with Shell:");
        showArray();
    }

    public void showArray() {
        int counter = 0;
        for (int i = 0; i < listNumber.length; i++) {
            System.out.print(listNumber[i] + "-");
            if (counter == 10) {
                System.out.println(listNumber[i] + "-");
                counter = 0;
            }
            counter++;
        }
    }

    public int[] createRandomArray() {
        for (int i = 0; i < listNumber.length; i++) {
            listNumber[i] = (int) (Math.random() * Integer.MAX_VALUE + 1);
        }
        return listNumber;
    }
//

    public void QuickSort(int start, int end) {
        // Check if there are elements to be sorted in the subarray
        if (start < end) {
            // Partition the array and get the partition index
            int partition_Index = partition(start, end);
            // Recursively sort elements before and after the partition
            QuickSort(start, partition_Index - 1);
            QuickSort(partition_Index + 1, end);
        }
    }

    public int partition(int start, int end) {
        // Select the pivot element, which is the last element in the array
        int pivot = listNumber[end];
        // Initialize the index of the smaller element
        int i = (start - 1);

        // Iterate through the subarray from 'start' to 'end - 1'
        for (int j = start; j <= end - 1; j++) {
            // If current element is smaller than or equal to the pivot
            if (listNumber[j] < pivot) {
                // Increment the index of the smaller element
                i++;
                // Swap array[i] and array[j]
                int temp = listNumber[i];
                listNumber[i] = listNumber[j];
                listNumber[j] = temp;
            }
        }
        // Swap the pivot element (array[end]) with the element at the index next to the smaller element (i + 1)
        int temp = listNumber[i + 1];
        listNumber[i + 1] = listNumber[end];
        listNumber[end] = temp;

        // Return the index of the pivot element after partitioning
        return (i + 1);
    }

    public void mergeSort() {
        // Create a temporary array to store values during sorting
        int[] temp = new int[listNumber.length];
        // Call the helper method to perform Merge Sort
        mergeSortHelper(0, listNumber.length - 1, temp);
    }

    private void mergeSortHelper(int low, int high, int[] temp) {
        // Check if the array contains more than one element
        if (low < high) {
            // Calculate the middle index
            int mid = low + (high - low) / 2;
            // Recursively sort the left half of the array
            mergeSortHelper(low, mid, temp);
            // Recursively sort the right half of the array
            mergeSortHelper(mid + 1, high, temp);
            // Merge the sorted halves
            merge(low, mid, high, temp);
        }
    }

    private void merge(int low, int mid, int high, int[] temp) {
        // Copy elements from the original array to the temporary array
        for (int i = low; i <= high; i++) {
            temp[i] = listNumber[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        // Merge the two sorted subarrays into the original array
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                listNumber[k] = temp[i];
                i++;
            } else {
                listNumber[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left subarray
        while (i <= mid) {
            listNumber[k] = temp[i];
            k++;
            i++;
        }
    }

    public void RadixSort() {
        int n = listNumber.length;
        int max = getMax(listNumber);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            // Initialize output and count arrays
            int[] output = new int[n];  // Array to store the sorted result
            int[] count = new int[10];  // Array to count the frequency of digits (0-9)

            // Count the frequency of each digit in the current position (exp)
            // Traverse the listNumber array to update the count array
            for (int i = 0; i < n; i++) {
                count[(listNumber[i] / exp) % 10]++;
            }

            // Update the count array to represent the position of each digit in the sorted array
            // Calculate cumulative counts for each digit
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // Build the sorted array based on the current digit (exp) and count array
            // Traverse the listNumber array from right to left to maintain stability
            for (int i = n - 1; i >= 0; i--) {
                // Place the elements in their correct positions in the output array
                // based on the count of the current digit
                output[count[(listNumber[i] / exp) % 10] - 1] = listNumber[i];

                // Decrease the count for the current digit
                count[(listNumber[i] / exp) % 10]--;
            }

            // Copy the sorted array from the output array back to the original listNumber array
            for (int i = 0; i < n; i++) {
                listNumber[i] = output[i];
            }
        }

    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
