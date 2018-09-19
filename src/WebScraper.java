import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {
    public static void main(String[] unused) {
        var count = 0;
        String words[] = urlToString("http://erdani.com/tdpl/hamlet.txt").replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        for (String word: words) {
            System.out.println(word);
            if (word.trim().equals("shot")) {
                count++;
            }
        }
        if (count != 0) {
            count++;
        }
        System.out.println(count);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
