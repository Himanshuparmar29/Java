import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EdgeSearchAutomation {
    public static void main(String[] args) {
        // List of 100 topics for search
        List<String> topics = generateTopics();

        int intervalMinutes = 15; // Interval in minutes

        System.out.println("Automated search program started. Performing 100 searches. Press Ctrl+C to stop.");

        try {
            for (int i = 0; i < topics.size(); i++) {
                // Get the current topic
                String query = topics.get(i);

                // Perform the search
                searchInEdge(query);

                System.out.println((i + 1) + "/100 Searched: " + query);

                // Wait for the next interval unless it's the last search
                if (i < topics.size() - 1) {
                    TimeUnit.MINUTES.sleep(intervalMinutes);
                }
            }
            System.out.println("Completed all 100 searches.");
        } catch (Exception e) {
            System.err.println("Program stopped due to an error: " + e.getMessage());
        }
    }

    private static void searchInEdge(String query) {
        try {
            // Construct the search URL
            String searchUrl = "https://www.bing.com/search?q=" + query.replace(" ", "+");

            // Open the default browser (Edge in this case)
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(searchUrl));
            } else {
                System.err.println("Desktop not supported. Cannot perform the search.");
            }
        } catch (Exception e) {
            System.err.println("Error while performing search: " + e.getMessage());
        }
    }

    private static List<String> generateTopics() {
        // Generate 100 unique topics for search
        List<String> topics = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            topics.add("Topic number " + i); // Replace with your actual topics
        }
        return topics;
    }
}
