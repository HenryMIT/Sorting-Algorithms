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

    public void QuickSort() {

    }

    //Stable algorithms
    public void MergeSort() {

    }

    public void RadixSort() {

    }

}
