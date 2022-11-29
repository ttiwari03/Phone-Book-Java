package phonebook;

import java.util.ArrayList;

/*
 *  Search sorted query using Binary Search.
 *  Binary Search ->
 *      When the list is sorted we can use the binary search technique to find items on the list.
 *      In this procedure, the entire list is divided into two sub-lists.
 *      If the item is found in the middle position, it returns the location, otherwise jumps to either left or right sub-list and do the same process again until finding the item or exceed the range.
 */
public class BinarySearch {
    public static void search() {
        Main.foundQueryCount = 0;

        for (int i = 0; i < Main.searchQueryData.size(); i++) {
            String name = Main.searchQueryData.get(i);
            int index = quickSort(QuickSort.quickSortNameData, name, 0, QuickSort.quickSortNameData.size() - 1);

            if (index != -1) {
                Main.foundQueryCount++;
            }
        }


    }

    private static int quickSort(ArrayList<String> quickSortNameData, String name, int start, int end) {
        int index = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (quickSortNameData.get(mid).compareTo(name) < 0) {
                start = mid + 1;
            } else if (quickSortNameData.get(mid).compareTo(name) > 0) {
                end = mid - 1;
            } else if (quickSortNameData.get(mid).compareTo(name) == 0) {
                index = mid;
                break;
            }
        }

        return index;
    }
}
