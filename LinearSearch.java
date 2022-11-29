package phonebook;

/*
 * Search data linearly.
 */
public class LinearSearch {
    public static void search() {
        Main.foundQueryCount = 0;

        for (int i = 0; i < Main.searchQueryData.size(); i++) {
            String query = Main.searchQueryData.get(i);

            for (int j = 0; j < Main.nameData.size(); j++) {
                if (Main.nameData.get(j).equals(query)) {
                    Main.foundQueryCount++;
                    break;
                }
            }
        }

    }
}
