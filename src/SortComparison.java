// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
        for (int i = 1; i <a.length ; ++i) {
            double val = a[i];
            int j = i-1;
            while((j>=0)&&(a[j]>val)){
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1] = val;
        }
        return a;
    }

    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        for (int i = 0; i <a.length ; i++) {
            int c = i;
            for (int j = i+1; j <a.length ; j++) {
                if(a[j] < a[c])
                    c=j;
            }
            double smallNum = a[c];
            a[c] = a[i];
            a[i] = smallNum;
        }
        return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
        recursiveQSort(a, 0, a.length-1);
        return a;
    }
    private static void recursiveQSort(double[] a, int lo, int hi){
        if(hi<=lo)
            return;
        int pivot = partition(a, lo, hi);
        recursiveQSort(a, lo, pivot-1);
        recursiveQSort(a, pivot+1, hi);
    }
    private static int partition (double a[], int lo, int hi){
        double pivot = a[hi];
        int i = (lo-1);
        for(int j = lo; j<hi;j++){
            if(a[j]< pivot) {
                i++;
                double tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        double tmp = a[i+1];
        a[i+1] = a[hi];
        a[hi] = tmp;
        return i+1;
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
        int current_size;
        int left_start;

        for(current_size=1; current_size <= a.length-1; current_size = 2*current_size){
            for (left_start=0; left_start < a.length-1;left_start+=2*current_size){
                int mid = Math.min(left_start+current_size-1, a.length-1);
                int right_end = Math.min(left_start + 2*current_size -1, a.length-1);
                merge(a, left_start, mid, right_end);
            }
        }
        return a;

    }
    private static void merge(double a[], int left, int mid, int right){
        int i, j, k;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double L[] = new double[n1];
        double R[] = new double[n2];
        for ( i= 0; i <n1 ; i++) {
            L[i] = a[left+i];
        }
        for (j=0;j<n2;j++){
            R[j] = a[mid+1+j];
        }
        i = 0;
        j = 0;
        k = left;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                a[k] =L[i];
                i++;
            }
            else{
                a[k] =R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k] = L[i];
            i++;
            k++;
        }
        while(j<n1){
            a[k] = R[j];
            j++;
            k++;
        }
    }



    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param array: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double array[]) {
        if(array == null)
        {
            return array;
        }

        if(array.length > 1)
        {
            int mid = array.length / 2;

            // Split left part
            double[] left = new double[mid];
            for(int i = 0; i < mid; i++)
            {
                left[i] = array[i];
            }

            // Split right part
            double[] right = new double[array.length - mid];
            for(int i = mid; i < array.length; i++)
            {
                right[i - mid] = array[i];
            }
            mergeSortRecursive(left);
            mergeSortRecursive(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while(i < left.length && j < right.length)
            {
                if(left[i] < right[j])
                {
                    array[k] = left[i];
                    i++;
                }
                else
                {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while(i < left.length)
            {
                array[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length)
            {
                array[k] = right[j];
                j++;
                k++;
            }
        }
        return array;
    }

    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

}//end class
