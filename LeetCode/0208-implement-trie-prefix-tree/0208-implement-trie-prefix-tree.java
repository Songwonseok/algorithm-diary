class Trie {
    private final Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;

        for(char c : word.toCharArray()) {
            if(!node.children.containsKey(c)) {
                node.children.put(c, new Node(c));
            }

            node = node.children.get(c);
        }

        node.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = findNode(word);

        return node != null && node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node node = findNode(prefix);

        return node != null;
    }

    private Node findNode(String word) {
        Node node = root;

        for(char c : word.toCharArray()) {
            if(!node.children.containsKey(c)) {
                return null;
            }

            node = node.children.get(c);
        }

        return node;
    }

    class Node {
        boolean isWord;
        char val;
        Map<Character, Node> children;
        
        Node() {
            isWord = false;
            children = new HashMap();
        }

        Node(char val) {
            this.val = val;
            children = new HashMap();
            isWord = false;
        }

    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */