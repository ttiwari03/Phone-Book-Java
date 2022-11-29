package phonebook;

import java.util.ArrayList;

/*
 *  Sort phone book data using Bubble Sort and then search using Jump search.
 *
 *  Jump Search ->
 *      Jump search works with ordered lists.
 *      It creates a block and tries to find the element in that block.
 *      If the item is not in the block, it shifts the entire block.
 *      The block size is based on the size of the list.
 *      If the size of the list is n then block size will be √n.
 *      After finding a correct block it finds the item using a linear search technique.
 *      The jump search lies between linear search and binary search according to its performance.
 */
public class JumpSearch {
    public static void search() {
        Main.foundQueryCount = 0;
        for (int i = 0; i < Main.searchQueryData.size(); i++) {
            String name = Main.searchQueryData.get(i);
            int queryIndex = jumpSearch(BubbleSort.bubbleSortNameData, name);
            if (queryIndex != -1) {
                Main.foundQueryCount++;
            }
        }
    }

    private static int jumpSearch(ArrayList<String> sortedNameDatabase, String name) {
        if (sortedNameDatabase.isEmpty()) {
            return -1;
        }

        int currentIndex = 0;
        int prevIndex = 0;
        int lastIndex = sortedNameDatabase.size() - 1;
        int blockSize = (int) Math.floor(Math.sqrt(lastIndex));

        while (sortedNameDatabase.get(currentIndex).compareTo(name) < 0) {
            if (currentIndex == lastIndex) {
                return -1;
            }

            prevIndex = currentIndex;
            currentIndex = Math.min(currentIndex + blockSize, lastIndex);
        }


        while (sortedNameDatabase.get(currentIndex).compareTo(name) > 0) {
            currentIndex--;
            if (currentIndex <= prevIndex) {
                return -1;
            }
        }

        if (sortedNameDatabase.get(currentIndex).compareTo(name) == 0) {
            return currentIndex;
        }

        return -1;
    }
}
