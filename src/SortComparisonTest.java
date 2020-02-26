/*
        numbers10.txt	        1	        2	    3	    avg
        Insertion Sort	        1.1886      1.24	0.5156	0.9814
        Insertion Sort	        0.026099	0.0104	0.0081	0.01486633333
        Quick Sort	            0.0202	    0.0165	0.0132	0.01663333333
        Merge Sort (Iterative)	0.037	    0.0306	0.0219	0.02983333333
        Merge Sort (Recursive)	0.0155	    0.0169	0.0153	0.0159
*/
/*
        numbers100.txt	        1	        2	    3	    avg
        Insertion Sort	        0.1332	    0.1647	0.0842	0.1273666667
        Selection Sort	        0.2348	    0.2554	0.1336	0.2079333333
        Quick Sort	            0.452899	0.4319	0.2704	0.3850663333
        Merge Sort (Iterative)	0.195	    0.158	0.089	0.1473333333
        Merge Sort (Recursive)	0.1164	    0.13	0.0983	0.1149
*/
/*
        numbers1000.txt	        1	    2	    3	    avg
        Insertion Sort	        13.6988	15.1151	9.1392	12.65103333
        Selection Sort	        4.6586	7.3193	3.1366	5.038166667
        Quick Sort	            2.9621	5.1338	2.1213	3.405733333
        Merge Sort (Iterative)	1.6563	1.5483	0.7955	1.333366667
        Merge Sort (Recursive)	1.1033	1.2108	0.5471	0.9537333333
*/
/*
        numbers1000Duplicates.txt	1	        2	    3	    avg
        Insertion Sort	            0.226799	0.2271	0.6251	0.3596663333
        Selection Sort	            0.451	    0.6017	0.3216	0.4581
        Quick Sort	                0.302899	0.7944	0.4252	0.5074996667
        Merge Sort (Iterative)	    0.415299	0.4352	0.2557	0.368733
        Merge Sort (Recursive)	    0.226899	0.33	0.1227	0.226533
*/
/*
        numbersNearlyOrdered1000.txt	1	        2	    3	    avg
        Insertion Sort	                0.048301	0.0481	0.1423	0.079567
        Selection Sort	                0.538399	2.2947	1.8484	1.560499667
        Quick Sort	                    4.969499	5.6465	3.1847	4.600233
        Merge Sort (Iterative)	        0.5194	    0.5635	0.3158	0.4662333333
        Merge Sort (Recursive)	        0.3331	    0.3142	0.325	0.3241
*/
/*
        numbersReverse1000.txt	1	        2	    3	    avg
        Insertion Sort	        0.424	    0.4329	1.2076	0.6881666667
        Selection Sort	        0.5638	    2.793	2.2819	1.879566667
        Quick Sort	            5.3486	    5.2351	3.6943	4.759333333
        Merge Sort (Iterative)	0.580499	0.4424	0.3509	0.457933
        Merge Sort (Recursive)	0.3235	    0.2406	0.1482	0.2374333333
*/
/*
        numbersSorted1000.txt	1	        2	    3	    avg
        Insertion Sort	        0.0042	    0.0046	0.0494	0.0194
        Selection Sort	        0.592	    2.8161	2.7647	2.0576
        Quick Sort	            5.649801	8.4694	3.8127	5.977300333
        Merge Sort (Iterative)	0.5912	    0.5847	0.3176	0.4978333333
        Merge Sort (Recursive)	0.350699	0.3438	0.184	0.292833
*/
/*
        a. Which of the sorting algorithms does the order of input have an impact on? Why?
            Random ordering affects insertionSort the most, in numbers1000.txt the average runtime
            was 12.651ms while within numbersSorted1000.txt, the average runtime is 0.0194ms. Reason
            being is that the first remaining element of the input is only compared with the
            right-most element of the sorted part of the array. Ordering affects insertionSort, selectionSort, both
            kinds of merge sorts and selection sort, while quickSort is relatively unaffected.

        b. Which algorithm has the biggest difference between the best and worst performance, based
        on the type of input, for the input of size 1000? Why?
            Random ordering affects insertionSort the most, in numbers1000.txt the average runtime
            was 12.651ms while within numbersSorted1000.txt, the average runtime is 0.0194ms. Reason
            being is that the first remaining element of the input is only compared with the
            right-most element of the sorted part of the array.

        c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
        based on the input size? Please consider only input files with random order for this answer.
               Insertion sort has the worst scalability between the largest and smallest inputs, with a difference of 11.66963333ms
               Merge sort (recursive) has the best scalability, with a difference of 0.9378333333ms
        d. Did you observe any difference between iterative and recursive implementations of merge
        sort?
            Merge sort recursive is faster then merge sort iterative in all cases of inputs.

        e. Which algorithm is the fastest for each of the 7 input files?
            numbers10.txt --> selection sort = 0.01486633333ms
            numbers100.txt --> merge sort recursive = 0.1149ms
            numbers1000.txt --> merge sort recursive = 0.9537333333ms
            numbers1000Duplicates --> merge sort recursive = 0.226533ms
            numbersNearlyOrdered1000 --> insertion sort = 0.079567ms
            numbersReverse1000.txt --> merge sort recursive = 0.2374333333ms
            numbersSorted1000.txt --> insertion sort = 0.0194ms
*/

import static java.lang.System.nanoTime;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */

    @Test
    public void testEmpty(){
        double[] array = new double[10];
        assertEquals("Checking insertion sort empty array", "[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]", Arrays.toString(SortComparison.insertionSort(array)));
        assertEquals("Checking selection sort empty array", "[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]", Arrays.toString(SortComparison.selectionSort(array)));
        assertEquals("Checking quick sort empty array", "[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]", Arrays.toString(SortComparison.quickSort(array)));
        assertEquals("Checking mergeSortIterative empty array", "[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]", Arrays.toString(SortComparison.mergeSortRecursive(array)));
        assertEquals("Checking mergeSortRecursive empty array", "[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]", Arrays.toString(SortComparison.mergeSortRecursive(array)));
    }

    @Test
    public void testOneElement(){
        double[] array = new double[1];
        array[0] = 69;
        assertEquals("Checking insertion sort one element array", "[69.0]", Arrays.toString(SortComparison.insertionSort(array)));
        assertEquals("Checking selection sort one element array", "[69.0]", Arrays.toString(SortComparison.selectionSort(array)));
        assertEquals("Checking quick sort one element array", "[69.0]", Arrays.toString(SortComparison.quickSort(array)));
        assertEquals("Checking mergeSortIterative one element array", "[69.0]", Arrays.toString(SortComparison.mergeSortRecursive(array)));
        assertEquals("Checking mergeSortRecursive one element array", "[69.0]", Arrays.toString(SortComparison.mergeSortRecursive(array)));
    }
    @Test
    //16, 21, 24, 25, 33, 50, 68, 79, 92, 99
    public void testTenElement(){
        double[] array = new double[]{1.0, 5199.0, 468.0, 1.0, 3212.0, 54100.0, 5198.0, 91.0, 1344568.0, 1.0};
        assertEquals("Checking insertion sort ten element unsorted array", "[1.0, 1.0, 1.0, 91.0, 468.0, 3212.0, 5198.0, 5199.0, 54100.0, 1344568.0]", Arrays.toString(SortComparison.insertionSort(array)));
        assertEquals("Checking selection sort ten element unsorted array", "[1.0, 1.0, 1.0, 91.0, 468.0, 3212.0, 5198.0, 5199.0, 54100.0, 1344568.0]", Arrays.toString(SortComparison.selectionSort(array)));
        assertEquals("Checking quick sort ten element unsorted array", "[1.0, 1.0, 1.0, 91.0, 468.0, 3212.0, 5198.0, 5199.0, 54100.0, 1344568.0]", Arrays.toString(SortComparison.quickSort(array)));
        assertEquals("Checking mergeSortIterative ten element unsorted array", "[1.0, 1.0, 1.0, 91.0, 468.0, 3212.0, 5198.0, 5199.0, 54100.0, 1344568.0]", Arrays.toString(SortComparison.mergeSortIterative(array)));
        assertEquals("Checking mergeSortRecursive ten element unsorted array", "[1.0, 1.0, 1.0, 91.0, 468.0, 3212.0, 5198.0, 5199.0, 54100.0, 1344568.0]", Arrays.toString(SortComparison.mergeSortRecursive(array)));
    }
    @Test
    public void testNineElement(){
        double[] array = new double[]{99.0, 16.0, 68.0, 1.0, 50.0, 21.0, 92.0, 68.0, 1.0};
        assertEquals("Checking insertion sort nine element unsorted array", "[1.0, 1.0, 16.0, 21.0, 50.0, 68.0, 68.0, 92.0, 99.0]", Arrays.toString(SortComparison.insertionSort(array)));
        assertEquals("Checking selection sort nine element unsorted array", "[1.0, 1.0, 16.0, 21.0, 50.0, 68.0, 68.0, 92.0, 99.0]", Arrays.toString(SortComparison.selectionSort(array)));
        assertEquals("Checking quick sort nine element unsorted array", "[1.0, 1.0, 16.0, 21.0, 50.0, 68.0, 68.0, 92.0, 99.0]", Arrays.toString(SortComparison.quickSort(array)));
        assertEquals("Checking mergeSortIterative nine element unsorted array", "[1.0, 1.0, 16.0, 21.0, 50.0, 68.0, 68.0, 92.0, 99.0]", Arrays.toString(SortComparison.mergeSortIterative(array)));
        assertEquals("Checking mergeSortRecursive nine element unsorted array", "[1.0, 1.0, 16.0, 21.0, 50.0, 68.0, 68.0, 92.0, 99.0]", Arrays.toString(SortComparison.mergeSortRecursive(array)));
    }

    @Test
    public void testNullArray(){
        double[] array= null;
        assertEquals("Checking sort with null array","null", Arrays.toString(SortComparison.insertionSort(array)));
        assertEquals("Checking sort with null array","null", Arrays.toString(SortComparison.selectionSort(array)));
        assertEquals("Checking sort with null array","null", Arrays.toString(SortComparison.quickSort(array)));
        assertEquals("Checking sort with null array","null", Arrays.toString(SortComparison.mergeSortIterative(array)));
        assertEquals("Checking sort with null array","null", Arrays.toString(SortComparison.mergeSortRecursive(array)));
    }

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args) throws IOException {
        ////////numbers10.txt///////////////////////////////////////////////////////////////////////////////////////
        BufferedReader br_numbers10 = new BufferedReader(new FileReader("numbers10.txt"));
        String line;
        double[] array = new double[10];
        int i =0;
        while(((line = br_numbers10.readLine())!= null)){
            array[i] = Double.parseDouble(line);
            i++;
        }
        // insertion sort
        long start = nanoTime();
        SortComparison.insertionSort(array);
        long finish = nanoTime();
        System.out.println("numbers10.txt -> insertion sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // selection sort
        start = nanoTime();
        SortComparison.selectionSort(array);
        finish = nanoTime();
        System.out.println("numbers10.txt -> selection sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        //quick sort
        start = nanoTime();
        SortComparison.quickSort(array);
        finish = nanoTime();
        System.out.println("numbers10.txt -> quick sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort iterative
        start = nanoTime();
        SortComparison.mergeSortIterative(array);
        finish = nanoTime();
        System.out.println("numbers10.txt -> merge sort (iterative) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort recursive
        start = nanoTime();
        SortComparison.mergeSortRecursive(array);
        finish = nanoTime();
        System.out.println("numbers10.txt -> merge sort (recursive) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        System.out.println();

        ////////numbers100.txt///////////////////////////////////////////////////////////////////////////////////////
        BufferedReader br_numbers100 = new BufferedReader(new FileReader("numbers100.txt"));
        array = new double[100];
        i =0;
        while(((line = br_numbers100.readLine())!= null)){
            array[i] = Double.parseDouble(line);
            i++;
        }
        // insertion sort
        start = nanoTime();
        SortComparison.insertionSort(array);
        finish = nanoTime();
        System.out.println("numbers100.txt -> insertion sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // selection sort
        start = nanoTime();
        SortComparison.selectionSort(array);
        finish = nanoTime();
        System.out.println("numbers100.txt -> selection sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        //quick sort
        start = nanoTime();
        SortComparison.quickSort(array);
        finish = nanoTime();
        System.out.println("numbers100.txt -> quick sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort iterative
        start = nanoTime();
        SortComparison.mergeSortIterative(array);
        finish = nanoTime();
        System.out.println("numbers100.txt -> merge sort (iterative) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort recursive
        start = nanoTime();
        SortComparison.mergeSortRecursive(array);
        finish = nanoTime();
        System.out.println("numbers100.txt -> merge sort (recursive) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        System.out.println();

        ////////numbers1000.txt///////////////////////////////////////////////////////////////////////////////////////
        BufferedReader br_numbers1000 = new BufferedReader(new FileReader("numbers1000.txt"));
        array = new double[1000];
        i =0;
        while(((line = br_numbers1000.readLine())!= null)){
            array[i] = Double.parseDouble(line);
            i++;
        }
        // insertion sort
        start = nanoTime();
        SortComparison.insertionSort(array);
        finish = nanoTime();
        System.out.println("numbers1000.txt -> insertion sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // selection sort
        start = nanoTime();
        SortComparison.selectionSort(array);
        finish = nanoTime();
        System.out.println("numbers1000.txt -> selection sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        //quick sort
        start = nanoTime();
        SortComparison.quickSort(array);
        finish = nanoTime();
        System.out.println("numbers1000.txt -> quick sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort iterative
        start = nanoTime();
        SortComparison.mergeSortIterative(array);
        finish = nanoTime();
        System.out.println("numbers1000.txt -> merge sort (iterative) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort recursive
        start = nanoTime();
        SortComparison.mergeSortRecursive(array);
        finish = nanoTime();
        System.out.println("numbers1000.txt -> merge sort (recursive) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        System.out.println();

        ////////numbers1000Duplicates.txt///////////////////////////////////////////////////////////////////////////////////////
        BufferedReader br_numbers1000Duplicates = new BufferedReader(new FileReader("numbers1000Duplicates.txt"));
        array = new double[1000];
        i =0;
        while(((line = br_numbers1000Duplicates.readLine())!= null)){
            array[i] = Double.parseDouble(line);
            i++;
        }
        // insertion sort
        start = nanoTime();
        SortComparison.insertionSort(array);
        finish = nanoTime();
        System.out.println("numbers1000Duplicates.txt -> insertion sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // selection sort
        start = nanoTime();
        SortComparison.selectionSort(array);
        finish = nanoTime();
        System.out.println("numbers1000Duplicates.txt -> selection sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        //quick sort
        start = nanoTime();
        SortComparison.quickSort(array);
        finish = nanoTime();
        System.out.println("numbers1000Duplicates.txt -> quick sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort iterative
        start = nanoTime();
        SortComparison.mergeSortIterative(array);
        finish = nanoTime();
        System.out.println("numbers1000Duplicates.txt -> merge sort (iterative) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort recursive
        start = nanoTime();
        SortComparison.mergeSortRecursive(array);
        finish = nanoTime();
        System.out.println("numbers1000Duplicates.txt -> merge sort (recursive) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        System.out.println();

        ////////numbersNearlyOrdered1000.txt///////////////////////////////////////////////////////////////////////////////////////
        BufferedReader br_numbersNearlyOrdered1000 = new BufferedReader(new FileReader("numbersNearlyOrdered1000.txt"));
        array = new double[1000];
        i =0;
        while(((line = br_numbersNearlyOrdered1000.readLine())!= null)){
            array[i] = Double.parseDouble(line);
            i++;
        }
        // insertion sort
        start = nanoTime();
        SortComparison.insertionSort(array);
        finish = nanoTime();
        System.out.println("numbersNearlyOrdered1000.txt -> insertion sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // selection sort
        start = nanoTime();
        SortComparison.selectionSort(array);
        finish = nanoTime();
        System.out.println("numbersNearlyOrdered1000.txt -> selection sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        //quick sort
        start = nanoTime();
        SortComparison.quickSort(array);
        finish = nanoTime();
        System.out.println("numbersNearlyOrdered1000.txt -> quick sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort iterative
        start = nanoTime();
        SortComparison.mergeSortIterative(array);
        finish = nanoTime();
        System.out.println("numbersNearlyOrdered1000.txt -> merge sort (iterative) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort recursive
        start = nanoTime();
        SortComparison.mergeSortRecursive(array);
        finish = nanoTime();
        System.out.println("numbersNearlyOrdered1000.txt -> merge sort (recursive) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        System.out.println();

        ////////numbersReverse1000.txt///////////////////////////////////////////////////////////////////////////////////////
        BufferedReader br_numbersReverse1000 = new BufferedReader(new FileReader("numbersReverse1000.txt"));
        array = new double[1000];
        i =0;
        while(((line = br_numbersReverse1000.readLine())!= null)){
            array[i] = Double.parseDouble(line);
            i++;
        }
        // insertion sort
        start = nanoTime();
        SortComparison.insertionSort(array);
        finish = nanoTime();
        System.out.println("numbersReverse1000.txt -> insertion sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // selection sort
        start = nanoTime();
        SortComparison.selectionSort(array);
        finish = nanoTime();
        System.out.println("numbersReverse1000.txt -> selection sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        //quick sort
        start = nanoTime();
        SortComparison.quickSort(array);
        finish = nanoTime();
        System.out.println("numbersReverse1000.txt -> quick sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort iterative
        start = nanoTime();
        SortComparison.mergeSortIterative(array);
        finish = nanoTime();
        System.out.println("numbersReverse1000.txt -> merge sort (iterative) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort recursive
        start = nanoTime();
        SortComparison.mergeSortRecursive(array);
        finish = nanoTime();
        System.out.println("numbersReverse1000.txt -> merge sort (recursive) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        System.out.println();

        ////////numbersSorted1000.txt///////////////////////////////////////////////////////////////////////////////////////
        BufferedReader br_numbersSorted1000 = new BufferedReader(new FileReader("numbersSorted1000.txt"));
        array = new double[1000];
        i =0;
        while(((line = br_numbersSorted1000.readLine())!= null)){
            array[i] = Double.parseDouble(line);
            i++;
        }
        // insertion sort
        start = nanoTime();
        SortComparison.insertionSort(array);
        finish = nanoTime();
        System.out.println("numbersSorted1000.txt -> insertion sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // selection sort
        start = nanoTime();
        SortComparison.selectionSort(array);
        finish = nanoTime();
        System.out.println("numbersSorted1000.txt -> selection sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        //quick sort
        start = nanoTime();
        SortComparison.quickSort(array);
        finish = nanoTime();
        System.out.println("numbersSorted1000.txt -> quick sort time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort iterative
        start = nanoTime();
        SortComparison.mergeSortIterative(array);
        finish = nanoTime();
        System.out.println("numbersSorted1000.txt -> merge sort (iterative) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        // merge sort recursive
        start = nanoTime();
        SortComparison.mergeSortRecursive(array);
        finish = nanoTime();
        System.out.println("numbersSorted1000.txt -> merge sort (recursive) time = "+ ((finish-start)*Math.pow(10, -6))+" nanoseconds");

        System.out.println();


    }

}
