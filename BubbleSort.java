package phonebook;

import java.util.ArrayList;

/*
 *  Sort data using Bubble sort.
 *
 *  Bubble Sort ->
 *      Bubble Sort is a comparison based sorting algorithm.
 *      In this algorithm adjacent elements are compared and swapped to make the correct sequence.
 *      This algorithm is simpler than other algorithms, but it has some drawbacks also.
 *      This algorithm is not suitable for a large number of data set.
 *      It takes much time to solve the sorting tasks.
 */
public class BubbleSort {

    public static ArrayList<String> bubbleSortNameData = new ArrayList<>(Main.nameData);
    public static ArrayList<Integer> bubbleSortNumberData = new ArrayList<>(Main.numberData);
    public static void sort() {

        long startTime = System.currentTimeMillis();
        long endTime;

        for (int i = 0; i < bubbleSortNameData.size() - 1; i++) {
            boolean isSwapped = false;
            for (int j = i + 1; j < bubbleSortNameData.size(); j++) {
                if (bubbleSortNameData.get(i).compareTo(bubbleSortNameData.get(j)) > 0) {
                    //  Swap name.
                    String name  = bubbleSortNameData.get(j);
                    bubbleSortNameData.set(j, bubbleSortNameData.get(i));
                    bubbleSortNameData.set(i, name);

                    //  Swap number
                    int number = bubbleSortNumberData.get(j);
                    bubbleSortNumberData.set(j, bubbleSortNumberData.get(i));
                    bubbleSortNumberData.set(i, number);

                    //  Set swapped to true.
                    isSwapped = true;
                }
                endTime = System.currentTimeMillis();
                if (endTime - startTime > Main.maxTime) {
                    Main.timeTakenLonger = true;
                    return;
                }

            }

            if (!isSwapped) {
                break;
            }
        }
    }
}
