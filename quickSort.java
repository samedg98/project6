/* Samed Ganibegovic
 * Date: 10/20/2019
 * Purpose: Empirical analysis of Quick Sort

 * Reference for algorithms - GeeksForGeeks
 */

package proj2;

import java.util.*;
import java.io.*;

public class quickSort {
	    int partition(int array[], int low, int high) {
	        int pivot = array[high];
	        int i = (low-1);
	        
	        for (int j=low; j<high; j++) {
	            if (array[j] <= pivot) {
	                i++;

	                int temp = array[i];
	                
	                array[i] = array[j];
	                array[j] = temp;
	            }
	        }

	        int temp = array[i+1];
	        
	        array[i+1] = array[high];
	        array[high] = temp;

	        return i+1;
	    }

	    void QuickSort(int array[], int low, int high){
	        if (low < high) {            
	        	int pi = partition(array, low, high);
	            
	        	QuickSort(array, low, pi-1);
	            QuickSort(array, pi+1, high);
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

	        quickSort obj = new quickSort();
	        
	        long rs1,rs2,rs3,re1,re2,re3;
	        long ss1,ss2,ss3,se1,se2,se3;
	        long as1,as2,as3,ae1,ae2,ae3;

	        int[] arrOneThousand = new int[1000];
	        int[] arrTenThousand = new int[10000];
	        int[] arrHundredThousand = new int[100000];

	        int n1 = arrOneThousand.length;
	        int n2 = arrTenThousand.length;
	        int n3 = arrHundredThousand.length;

	        //creates three input types for arrays - one thousand
	        obj.randomArray(arrOneThousand);
	        rs1 = System.nanoTime();
	        obj.QuickSort(arrOneThousand, 0, n1-1);
	        re1 = System.nanoTime();

	        obj.sortedArray(arrOneThousand);
	        ss1 = System.nanoTime();
	        obj.QuickSort(arrOneThousand, 0, n1-1);
	        se1 = System.nanoTime();

	        obj.almostSortedArray(arrOneThousand);
	        as1 = System.nanoTime();
	        obj.QuickSort(arrOneThousand, 0, n1-1);
	        ae1 = System.nanoTime();

	        System.out.println("-----Quick Sort-----\n");
	        
	        System.out.println(arrOneThousand.length + " random elements: " +(re1-rs1) + " nanoseconds");
	        System.out.println(arrOneThousand.length + " sorted elements: " +(se1-ss1) + " nanoseconds");
	        System.out.println(arrOneThousand.length + " almost sorted elements: " +(ae1-as1) + " nanoseconds");

	        //creates three input types for arrays - ten thousand 
	        obj.randomArray(arrTenThousand);
	        rs2 = System.nanoTime();
	        obj.QuickSort(arrTenThousand, 0, n2-1);
	        re2 = System.nanoTime();

	        obj.sortedArray(arrTenThousand);
	        ss2 = System.nanoTime();
	        obj.QuickSort(arrTenThousand, 0, n2-1);
	        se2 = System.nanoTime();

	        obj.almostSortedArray(arrTenThousand);
	        as2 = System.nanoTime();
	        obj.QuickSort(arrTenThousand, 0, n2-1);
	        ae2 = System.nanoTime();

	        System.out.println();
	        
	        System.out.println(arrTenThousand.length + " random elements: " + (re2-rs2) + " nanoseconds");
	        System.out.println(arrTenThousand.length + " sorted elements: " + (se2-ss2) + " nanoseconds");
	        System.out.println(arrTenThousand.length + " almost sorted elements: " + (ae2-as2) + " nanoseconds");

	        //sorted and almost sorted cause stack overflow
	        obj.randomArray(arrHundredThousand);
	        rs3 = System.nanoTime();
	        obj.QuickSort(arrHundredThousand, 0, n3-1);
	        re3 = System.nanoTime();

	        obj.sortedArray(arrHundredThousand);
	        ss3 = System.nanoTime();
	        obj.QuickSort(arrHundredThousand, 0, n3-1);
	        se3 = System.nanoTime();

	        obj.almostSortedArray(arrHundredThousand);
	        as3 = System.nanoTime();
	        obj.QuickSort(arrHundredThousand, 0, n3-1);
	        ae3 = System.nanoTime();

	        System.out.println();
	        
	        System.out.println(arrHundredThousand.length + " random elements: " + (re3-rs3) + " nanoseconds");
	        System.out.println(arrHundredThousand.length + " sorted elements: " + (se3-ss3) + " nanoseconds");
	        System.out.println(arrHundredThousand.length + " almost sorted elements: " + (ae3-as3) + " nanoseconds");

	    }
	}
