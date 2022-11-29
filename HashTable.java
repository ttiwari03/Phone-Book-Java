package phonebook;

import java.util.HashMap;

/*
 *  Searching contact using hash mechanism.
 */
public class HashTable {
    public static HashMap<String, Integer> phonebookData = new HashMap<>();
  
    /*
     *  Create hash table from phone book data
     */
    public static void create() {
        for (int i = 0; i < Main.nameData.size(); i++) {
            String name = Main.nameData.get(i);
            int number = Main.numberData.get(i);

            phonebookData.put(name, number);
        }
    }

    public static void search() {
        int defaultNumber = -1;
        Main.foundQueryCount = 0;

        for (int i = 0; i < Main.searchQueryData.size(); i++) {
            String query = Main.searchQueryData.get(i);

            int number = phonebookData.getOrDefault(query, defaultNumber);

            if (number != defaultNumber) {
                Main.foundQueryCount++;
            }
        }
    }
}
