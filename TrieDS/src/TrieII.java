public class TrieII {

    public TrieNodeII root;

    public TrieII() {
        root = new TrieNodeII();
    }

    public void insert(String word) {
        TrieNodeII curr = root;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            TrieNodeII node = curr.children.get(ch);
            if(node==null){
                node = new TrieNodeII();
                curr.children.put(ch, node);
            }
            curr = node;
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNodeII curr = root;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            TrieNodeII node = curr.children.get(ch);
            if(node==null){
                return false;
            }
            curr = node;
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNodeII curr = root;
        for(int i=0; i<prefix.length();i++){
            char ch = prefix.charAt(i);
            TrieNodeII node = curr.children.get(ch);
            if(node==null){
                return false;
            }
            curr = node;
        }
        return true;
    }

    public int countWordsEqualTo(String word) {

    }

    public int countWordsStartingWith(String prefix) {

    }

}
