import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
        double[] array = new double[]{99.0, 16.0, 25.0, 33.0, 79.0, 50.0, 21.0, 92.0, 24.0, 68.0};
        assertEquals("Checking insertion sort ten element unsorted array", "[16.0, 21.0, 24.0, 25.0, 33.0, 50.0, 68.0, 79.0, 92.0, 99.0]", Arrays.toString(SortComparison.insertionSort(array)));
        assertEquals("Checking selection sort ten element unsorted array", "[16.0, 21.0, 24.0, 25.0, 33.0, 50.0, 68.0, 79.0, 92.0, 99.0]", Arrays.toString(SortComparison.selectionSort(array)));
        assertEquals("Checking quick sort ten element unsorted array", "[16.0, 21.0, 24.0, 25.0, 33.0, 50.0, 68.0, 79.0, 92.0, 99.0]", Arrays.toString(SortComparison.quickSort(array)));
        assertEquals("Checking mergeSortIterative ten element unsorted array", "[16.0, 21.0, 24.0, 25.0, 33.0, 50.0, 68.0, 79.0, 92.0, 99.0]", Arrays.toString(SortComparison.mergeSortRecursive(array)));
        assertEquals("Checking mergeSortRecursive ten element unsorted array", "[16.0, 21.0, 24.0, 25.0, 33.0, 50.0, 68.0, 79.0, 92.0, 99.0]", Arrays.toString(SortComparison.mergeSortRecursive(array)));

    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
