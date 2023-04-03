/* Samed Ganibegovic
 * Date: 10/20/2019
 * Purpose: Empirical analysis of Bubble Sort Without Swaps Counting

 * Reference for algorithms - GeeksForGeeks
 */

package proj2;

import java.util.*;
import java.io.*;

public class bubbleSortWithoutSwaps {

    void BubbleSortWithoutSwaps(int arr[]){
        int n = arr.length;
        
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    //random integers generated
    void randomArray (int array[]) {
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*((10000-1)+1)+1);
        }
    }
    
    //sorted array generated
    void sortedArray (int array[]) {
        int j = 1;
        
        for(int i = 0; i < array.length; i++){
            array[i] = j;
            j++;
        }
    }
    
    //tenth value equals a number 1-10000
    void almostSortedArray (int array[]){
        int j = 1;
        
        for(int i = 0; i < array.length; i++) {
            array[i] = j;
            j++;
        }
        
        for(int i = 9; i < array.length; i=i+10){
            array[i] = (int)(Math.random()*((10000-1)+1)+1);
        }

    }

    public static void main(String[] args) {
        bubbleSortWithoutSwaps obj = new bubbleSortWithoutSwaps();
        
        long rs1,rs2,rs3,re1,re2,re3;
        long ss1,ss2,ss3,se1,se2,se3;
        long as1,as2,as3,ae1,ae2,ae3;

        int[] arrOneThousand = new int[1000];
        int[] arrTenThousand = new int[10000];
        int[] arrHundredThousand = new int[100000];
        
        //random array created
        obj.randomArray(arrOneThousand);
        obj.randomArray(arrTenThousand);
        obj.randomArray(arrHundredThousand);
        
        rs1 = System.nanoTime();
        obj.BubbleSortWithoutSwaps(arrOneThousand);
        re1 = System.nanoTime();

        rs2 = System.nanoTime();
        obj.BubbleSortWithoutSwaps(arrTenThousand);
        re2 = System.nanoTime();

        rs3 = System.nanoTime();
        obj.BubbleSortWithoutSwaps(arrHundredThousand);
        re3 = System.nanoTime();

        System.out.println("-----Bubble Sort Without Swaps Counting-----\n");
        
        System.out.println(arrOneThousand.length + " random elements: " +(re1-rs1) + " nanoseconds");
        System.out.println(arrTenThousand.length + " random elements: " + (re2-rs2) + " nanoseconds");
        System.out.println(arrHundredThousand.length + " random elements: " + (re3-rs3) + " nanoseconds");
        
        //sorted arrays created
        obj.sortedArray(arrOneThousand);
        obj.sortedArray(arrTenThousand);
        obj.sortedArray(arrHundredThousand);
        
        ss1 = System.nanoTime();
        obj.BubbleSortWithoutSwaps(arrOneThousand);
        se1 = System.nanoTime();

        ss2 = System.nanoTime();
        obj.BubbleSortWithoutSwaps(arrTenThousand);
        se2 = System.nanoTime();

        ss3 = System.nanoTime();
        obj.BubbleSortWithoutSwaps(arrHundredThousand);
        se3 = System.nanoTime();

        System.out.println();
        
        System.out.println(arrOneThousand.length + " sorted elements: " +(se1-ss1) + " nanoseconds");
        System.out.println(arrTenThousand.length + " sorted elements: " + (se2-ss2) + " nanoseconds");
        System.out.println(arrHundredThousand.length + " sorted elements: " + (se3-ss3) + " nanoseconds");
        
        //almost sorted arrays created
        obj.almostSortedArray(arrOneThousand);
        obj.almostSortedArray(arrTenThousand);
        obj.almostSortedArray(arrHundredThousand);
        
        as1 = System.nanoTime();
        obj.BubbleSortWithoutSwaps(arrOneThousand);
        ae1 = System.nanoTime();

        as2 = System.nanoTime();
        obj.BubbleSortWithoutSwaps(arrTenThousand);
        ae2 = System.nanoTime();

        as3 = System.nanoTime();
        obj.BubbleSortWithoutSwaps(arrHundredThousand);
        ae3 = System.nanoTime();

        System.out.println();
        
        System.out.println(arrOneThousand.length + " almost sorted elements: " +(ae1-as1) + " nanoseconds");
        System.out.println(arrTenThousand.length + " almost sorted elements: " + (ae2-as2) + " nanoseconds");
        System.out.println(arrHundredThousand.length + " almost sorted elements: " + (ae3-as3) + " nanoseconds");
    }

}
