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
    int[] listNumber=new int[100000];
    
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
        System.out.println("List Number {");
        for (int i = 0; i < listNumber.length; i++) {
            System.out.println(listNumber[i]);
        }
        System.out.println("}");
    }

    //Basic algorithm
    public void BubbleSort() {
        int temp = 0;
        for (int i = 0; i < listNumber.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (listNumber[j] < listNumber[j+1]) {
                    temp=listNumber[j+1];
                    listNumber[j+1]=listNumber[j];
                    listNumber[j]=temp;
                }
            }
        }
    }

    //Unstable algorithms
    public void ShellSort() {

    }

    public void QuickSort() {

    }

    //Stable algorithms
    public void MergeSort() {

    }

    public void RadixSort() {

    }

}
