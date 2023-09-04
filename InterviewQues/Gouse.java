import java.util.*;

    public class permutations {
        static public List<String> permuteUnique(String s) {
            List<String> ansList = new ArrayList<>();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            backtrack(chars, new StringBuilder(), ansList, new boolean[chars.length]);
            return ansList;
        }

        static public void backtrack(char[] chars, StringBuilder temp, List<String> ansList, boolean[] used) {
            if (temp.length() == chars.length) {
                ansList.add(temp.toString());
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (used[i] || (i > 0 && chars[i] == chars[i - 1] && used[i - 1])) continue;
                if (temp.length() == 0 && Character.isDigit(chars[i])) continue; // Skip digits at the beginning
                used[i] = true;
                temp.append(chars[i]);
                backtrack(chars, temp, ansList, used);
                used[i] = false;
                temp.deleteCharAt(temp.length() - 1);
            }
        }


    public static void main(String[] args) {
        List<String> ans = permuteUnique("B3a");
        System.out.println(ans.toString());
    }
}
