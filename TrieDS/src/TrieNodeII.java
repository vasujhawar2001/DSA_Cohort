import java.util.HashMap;

public class TrieNodeII {
    public HashMap<Character,TrieNodeII> children;
    boolean isEndOfWord;

    public TrieNodeII(){
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
