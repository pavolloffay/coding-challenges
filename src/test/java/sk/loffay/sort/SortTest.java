package sk.loffay.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class SortTest {

    @Test
    public void testSortingAlgorithms() {
        List<Sort<Integer>> sortsToTest = new ArrayList<>(Arrays.asList(
                new BubbleSort<>(),
                new InsertionSort<>(),
                new SelectionSort<>(),
                new HeapSort<>(),
                new MergeSort<>(),
                new QuickSort<>()));

        int runs = 5;
        int arrSize = 20;
        while (runs-- > 0) {
            for (Sort<Integer> sort: sortsToTest) {
                Integer[] arr = Utils.generateArray(arrSize);
                sort.sort(arr);
                Assert.assertTrue(sort.getClass().toString() + Arrays.toString(arr), Utils.isSorted(arr));
            }
            arrSize = arrSize*5;
        }
    }
}
