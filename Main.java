package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;

/*
 *  This program demonstrate various searching and sorting technique and their performance.
 */
public class Main {
    public static final String phoneDatabaseFileName = "directory.txt";
    public static final String queryFileName = "find.txt";
    public static final ArrayList<String> nameData = new ArrayList<>();
    public static final ArrayList<Integer> numberData = new ArrayList<>();
    public static final ArrayList<String> searchQueryData = new ArrayList<>();
    public static int foundQueryCount = 0;
    public static boolean timeTakenLonger = false;
    public static long maxTime = 0;

    public static void main(String[] args) {
    
        System.out.println("Reading contact data...");
        readPhoneData();
        System.out.println();
        System.out.println("Reading search query data...");
        readSearchQuery();
        System.out.println();
        System.out.println("Searching using various algorithms...(some algorithms take more time)");
        System.out.println();
        linearSearch();

        bubbleSortAndJumpSearch();

        quickSortAndBinarySearch();

        hashSearch();

    }

    private static void hashSearch() {
        long totalStartTime = System.currentTimeMillis();
        System.out.println("Start searching (hash table)...");

        long startingTime = System.currentTimeMillis();
        HashTable.create();
        long endingTime = System.currentTimeMillis();
        String creationTime = calculateTimeTaken(startingTime, endingTime);

        startingTime = System.currentTimeMillis();
        HashTable.search();
        endingTime = System.currentTimeMillis();
        String searchingTime = calculateTimeTaken(startingTime, endingTime);

        long totalEndTime = System.currentTimeMillis();
        String totalTimeTaken = calculateTimeTaken(totalStartTime, totalEndTime);

        System.out.printf("Found %d / %d entries. Time taken: %s%n", foundQueryCount, searchQueryData.size(), totalTimeTaken);
        System.out.printf("Creating time: %s%n", creationTime);
        System.out.printf("Searching time: %s%n", searchingTime);
    }

    private static void quickSortAndBinarySearch() {
        System.out.println("Start searching (quick sort + binary search)...");

        long totalStartTime = System.currentTimeMillis();

        //  Performing quick sort.
        long startingTime = System.currentTimeMillis();
        QuickSort.sort();
        long endingTime = System.currentTimeMillis();
        String sortingTimeTaken = calculateTimeTaken(startingTime, endingTime);

        //  Performing binary search.
        startingTime = System.currentTimeMillis();
        BinarySearch.search();
        endingTime = System.currentTimeMillis();
        String timeTaken = calculateTimeTaken(startingTime, endingTime);

        long totalEndTime = System.currentTimeMillis();
        String totalTimeTaken = calculateTimeTaken(totalStartTime, totalEndTime);

        System.out.printf("Found %d / %d entries. Time taken: %s%n", foundQueryCount, searchQueryData.size(), totalTimeTaken);
        System.out.printf("Sorting time: %s%n", sortingTimeTaken);
        System.out.printf("Searching time: %s%n", timeTaken);
        System.out.println();
    }

    private static void bubbleSortAndJumpSearch() {
        System.out.println("Start searching (bubble sort + jump search)...");
        long totalStartTime = System.currentTimeMillis();
        //  Performing bubble sort.
        long startingTime = System.currentTimeMillis();
        BubbleSort.sort();
        long endingTime = System.currentTimeMillis();
        String sortingTimeTaken = calculateTimeTaken(startingTime, endingTime);


        if (timeTakenLonger) {
            startingTime = System.currentTimeMillis();
            LinearSearch.search();
            endingTime = System.currentTimeMillis();
            String timeTaken = calculateTimeTaken(startingTime, endingTime);
            long totalEndTime = System.currentTimeMillis();
            String totalTimeTaken = calculateTimeTaken(totalStartTime, totalEndTime);

            System.out.printf("Found %d / %d entries. Time taken: %s%n", foundQueryCount, searchQueryData.size(), totalTimeTaken);
            System.out.printf("Sorting time: %s - STOPPED, moved to linear search%n", sortingTimeTaken);
            System.out.printf("Searching time: %s%n", timeTaken);
            System.out.println();

        } else {
            //  Performing jump search.
            startingTime = System.currentTimeMillis();
            JumpSearch.search();
            endingTime = System.currentTimeMillis();
            String timeTaken = calculateTimeTaken(startingTime, endingTime);
            long totalEndTime = System.currentTimeMillis();
            String totalTimeTaken = calculateTimeTaken(totalStartTime, totalEndTime);
            System.out.printf("Found %d / %d entries. Time taken: %s%n", foundQueryCount, searchQueryData.size(), totalTimeTaken);
            System.out.printf("Sorting time: %s%n", sortingTimeTaken);
            System.out.printf("Searching time: %s%n", timeTaken);
            System.out.println();
        }
    }

    private static void linearSearch() {
        //  Performing linear search.
        System.out.println("Start searching (linear search)...");
        long startingTime = System.currentTimeMillis();
        LinearSearch.search();
        long endingTime = System.currentTimeMillis();
        String timeTaken = calculateTimeTaken(startingTime, endingTime);
        System.out.printf("Found %d / %d entries. Time taken: %s%n", foundQueryCount, searchQueryData.size(), timeTaken);
        System.out.println();


        //  Finding maximum time for bubble sort
        maxTime = (endingTime - startingTime) * 10;
    }

    private static String calculateTimeTaken(long startingTime, long endingTime) {

        long milliseconds = endingTime - startingTime;

        long seconds = milliseconds / 1000;
        milliseconds = milliseconds - seconds * 1000;
        long minutes = milliseconds / 60000;
        milliseconds = milliseconds - minutes * 60000;
        return "%d min. %d sec. %d ms.".formatted(minutes, seconds, milliseconds);
    }

    private static void readSearchQuery() {
        File file = new File(queryFileName);
        try (Scanner readFile = new Scanner(file)) {
            while (readFile.hasNextLine()) {
                searchQueryData.add(readFile.nextLine());
            }
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }

    private static void readPhoneData() {
        File file = new File(phoneDatabaseFileName);
        try (Scanner readFile = new Scanner(file)) {
            while (readFile.hasNextLine()) {
                String input = readFile.nextLine();
                int firstSpaceIndex = input.indexOf(" ");
                String name = input.substring( firstSpaceIndex + 1);
                int phoneNumber = Integer.parseInt(input.substring(0, firstSpaceIndex));
                nameData.add(name);
                numberData.add(phoneNumber);

            }
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
}
