public class RabinKarpAlgo {

    private static final int d = 256; // Number of characters in the alphabet

    public static void search(String pattern, String text, int q) {
        int m = pattern.length();
        int n = text.length();
        int p = 0; // Hash value for pattern
        int t = 0; // Hash value for text
        int h = 1;

        // Calculate h = d^(m-1) % q
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and the first m characters of text
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over the text one by one and check for a match
        for (int i = 0; i <= n - m; i++) {
            // If the hash values of the pattern and the current window of text match
            if (p == t) {
                // Check if the pattern and the current window of text actually match
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate the hash value for the next window of text
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) {
                    t += q;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";
        int q = 101; // A prime number

        search(pattern, text, q);
    }
}