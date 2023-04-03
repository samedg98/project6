/* Samed Ganibegovic
 * Purpose: Empirical analysis of Merge Sort

 * Reference for algorithms - GeeksForGeeks
 */

package proj2;

public class mergeSort {

    void merge(int array[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = array[l + i];
        
        for (int j=0; j<n2; ++j)
            R[j] = array[m + 1+ j];

        int i = 0, j = 0;
        int k = l;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    void MergeSort(int array[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;

            MergeSort(array, l, m);
            MergeSort(array, m+1, r);

            merge(array, l, m, r);
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

        mergeSort obj = new mergeSort();

        long rs1,rs2,rs3,re1,re2,re3;
        long ss1,ss2,ss3,se1,se2,se3;
        long as1,as2,as3,ae1,ae2,ae3;

        int[] arrOneThousand = new int[1000];
        int[] arrTenThousand = new int[10000];
        int[] arrHundredThousand = new int[100000];

        int n1 = arrOneThousand.length;
        int n2 = arrTenThousand.length;
        int n3 = arrHundredThousand.length;

        //random array created
        obj.randomArray(arrOneThousand);
        obj.randomArray(arrTenThousand);
        obj.randomArray(arrHundredThousand);

        rs1 = System.nanoTime();
        obj.MergeSort(arrOneThousand, 0, n1-1);
        re1 = System.nanoTime();

        rs2 = System.nanoTime();
        obj.MergeSort(arrTenThousand, 0, n2-1);
        re2 = System.nanoTime();

        rs3 = System.nanoTime();
        obj.MergeSort(arrHundredThousand, 0 , n3-1);
        re3 = System.nanoTime();

        System.out.println("-----Merge Sort-----\n");
        
        System.out.println(arrOneThousand.length + " random elements: " +(re1-rs1) + " nanoseconds");
        System.out.println(arrTenThousand.length + " random elements: " + (re2-rs2) + " nanoseconds");
        System.out.println(arrHundredThousand.length + " random elements: " + (re3-rs3) + " nanoseconds");

        //sorted arrays created
        obj.sortedArray(arrOneThousand);
        obj.sortedArray(arrTenThousand);
        obj.sortedArray(arrHundredThousand);

        ss1 = System.nanoTime();
        obj.MergeSort(arrOneThousand, 0, n1-1);
        se1 = System.nanoTime();

        ss2 = System.nanoTime();
        obj.MergeSort(arrTenThousand, 0, n2-1);
        se2 = System.nanoTime();

        ss3 = System.nanoTime();
        obj.MergeSort(arrHundredThousand, 0, n3-1);
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
        obj.MergeSort(arrOneThousand, 0, n1-1);
        ae1 = System.nanoTime();

        as2 = System.nanoTime();
        obj.MergeSort(arrTenThousand, 0, n2-1);
        ae2 = System.nanoTime();

        as3 = System.nanoTime();
        obj.MergeSort(arrHundredThousand, 0, n3-1);
        ae3 = System.nanoTime();

        System.out.println();
        
        System.out.println(arrOneThousand.length + " almost sorted elements: " +(ae1-as1) + " nanoseconds");
        System.out.println(arrTenThousand.length + " almost sorted elements: " + (ae2-as2) + " nanoseconds");
        System.out.println(arrHundredThousand.length + " almost sorted elements: " + (ae3-as3) + " nanoseconds");

    }

}
