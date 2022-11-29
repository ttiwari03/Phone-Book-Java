package phonebook;

import java.util.ArrayList;

/*
 *  Sort data using Quick Sort.
 *  Quick Sort ->
 *      The quicksort technique is done by separating the list into two parts.
 *      Initially, a pivot element is chosen by partitioning algorithm.
 *      The left part of the pivot holds the smaller values than the pivot, and right part holds the larger value.
 *      After partitioning, each separate lists are partitioned using the same procedure.
 */
public class QuickSort {

    public static ArrayList<String> quickSortNameData = new ArrayList<>(Main.nameData);
    public static ArrayList<Integer> quickSortNumberData = new ArrayList<>(Main.numberData);

    public static void sort() {
        quickSort(quickSortNameData, quickSortNumberData, 0, quickSortNameData.size() - 1);
    }

    private static void quickSort(ArrayList<String> quickSortNameData, ArrayList<Integer> quickSortNumberData, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(quickSortNameData, quickSortNumberData, start, end);

            quickSort(quickSortNameData, quickSortNumberData, start, partitionIndex - 1);
            quickSort(quickSortNameData, quickSortNumberData, partitionIndex + 1, end);
        }
    }

    private static int partition(ArrayList<String> quickSortNameData, ArrayList<Integer> quickSortNumberData, int start, int end) {

        String pivot = quickSortNameData.get(end);
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (quickSortNameData.get(j).compareTo(pivot) < 0) {
                i++;

                //  Swap name.
                String name = quickSortNameData.get(i);
                quickSortNameData.set(i, quickSortNameData.get(j));
                quickSortNameData.set(j, name);

                //  Swap number
                int number = quickSortNumberData.get(i);
                quickSortNumberData.set(i, quickSortNumberData.get(j));
                quickSortNumberData.set(j, number);
            }
        }

        //  Swap name.
        String name = quickSortNameData.get(i + 1);
        quickSortNameData.set(i + 1, quickSortNameData.get(end));
        quickSortNameData.set(end, name);

        //  Swap number
        int number = quickSortNumberData.get(i + 1);
        quickSortNumberData.set(i + 1, quickSortNumberData.get(end));
        quickSortNumberData.set(end, number);

        return i+1;
    }
}
