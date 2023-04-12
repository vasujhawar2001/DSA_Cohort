import java.util.ArrayList;
import java.util.List;

public class KMPAlgo {
    private int[] buildLpsTable(String pattern) {
        int[] lps = new int[pattern.length()];
        int prevLPS = 0;
        int i = 1;

        while(i<pattern.length()){
            if(pattern.charAt(prevLPS)==pattern.charAt(i)){
                lps[i]=prevLPS+1;
                i++;
                prevLPS++;
            }
            else{
                if(prevLPS==0){
                    lps[i]=0;
                    i++;
                }
                else{
                    prevLPS = lps[prevLPS-1];
                }
            }
        }
        return lps;
    }


    public List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();

        int[] lps = buildLpsTable(pattern);
        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                matches.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        return matches;
    }

    public static void main(String[] args) {
        KMPAlgo kmp = new KMPAlgo();
        List<Integer> ans = kmp.kmpSearch("aaaxaaaaa", "aaaa");
        System.out.println(ans.toString());
    }


}
