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
    public void ShellSort() {
        int n = listNumber.length;
        int gap = n / 2; // Divide the array into 2 for the first time
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int key = listNumber[i];
                int j = i;
                while (j >= gap && listNumber[j - gap] > key) {
                    listNumber[j] = listNumber[j - gap];
                    j -= gap;
                }
                listNumber[j] = key;
            }
            gap /= 2;//Divide the previous interval into 2
        }
    }

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

    //Stable algorithms
    public void MergeSort() {

    }

    public void RadixSort() {

    }

}
