/* Samed Ganibegovic
 * Purpose: Empirical analysis of Bubble Sort With Swaps Counting

 * Reference for algorithms - GeeksForGeeks
 */

package proj2;

import java.util.*;
import java.io.*;

public class bubbleSortWithSwaps {

	void BubbleSortWithSwaps(int array[]) {
        int i, j, temp;
        boolean swapped;
        
        for (i = 0; i < array.length - 1; i++){
            swapped = false;
            
            for (j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                   
                    swapped = true;
                }
            }
            
            if (swapped == false)
                break;
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
        bubbleSortWithSwaps obj = new bubbleSortWithSwaps();

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
        obj.BubbleSortWithSwaps(arrOneThousand);
        re1 = System.nanoTime();

        rs2 = System.nanoTime();
        obj.BubbleSortWithSwaps(arrTenThousand);
        re2 = System.nanoTime();

        rs3 = System.nanoTime();
        obj.BubbleSortWithSwaps(arrHundredThousand);
        re3 = System.nanoTime();

        System.out.println("-----Bubble Sort With Swaps Counting-----");
        
        System.out.println(arrOneThousand.length + " random elements: " +(re1-rs1) + " nanoseconds");
        System.out.println(arrTenThousand.length + " random elements: " + (re2-rs2) + " nanoseconds");
        System.out.println(arrHundredThousand.length + " random elements: " + (re3-rs3) + " nanoseconds");
        
        //sorted arrays created
        obj.sortedArray(arrOneThousand);
        obj.sortedArray(arrTenThousand);
        obj.sortedArray(arrHundredThousand);
        
        ss1 = System.nanoTime();
        obj.BubbleSortWithSwaps(arrOneThousand);
        se1 = System.nanoTime();

        ss2 = System.nanoTime();
        obj.BubbleSortWithSwaps(arrTenThousand);
        se2 = System.nanoTime();

        ss3 = System.nanoTime();
        obj.BubbleSortWithSwaps(arrHundredThousand);
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
        obj.BubbleSortWithSwaps(arrOneThousand);
        ae1 = System.nanoTime();

        as2 = System.nanoTime();
        obj.BubbleSortWithSwaps(arrTenThousand);
        ae2 = System.nanoTime();

        as3 = System.nanoTime();
        obj.BubbleSortWithSwaps(arrHundredThousand);
        ae3 = System.nanoTime();

        System.out.println();
        
        System.out.println(arrOneThousand.length + " almost sorted elements: " +(ae1-as1) + " nanoseconds");
        System.out.println(arrTenThousand.length + " almost sorted elements: " + (ae2-as2) + " nanoseconds");
        System.out.println(arrHundredThousand.length + " almost sorted elements: " + (ae3-as3) + " nanoseconds");
    }

}
