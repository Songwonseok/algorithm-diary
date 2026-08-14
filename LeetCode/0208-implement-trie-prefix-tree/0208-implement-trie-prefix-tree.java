class Trie {
    private Node root;

    public Trie() {
        root = new Node();   
    }
    
    public void insert(String word) {
        Node curr = root;

        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            
            curr = curr.children.get(c);
        }

        curr.isLast = true;
    }
    
    public boolean search(String word) {
        Node last = findLast(word);

        return last != null && last.isLast;
    }
    
    public boolean startsWith(String prefix) {
        Node last = findLast(prefix);

        return last != null;
    }

    public Node findLast(String word) {
        Node curr = root;

        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return null;
            }
            
            curr = curr.children.get(c);
        }

        return curr;
    } 

    class Node {
        char val;
        boolean isLast;
        Map<Character, Node> children;

        Node() {
            isLast = false;
            children = new HashMap();
        }

        Node(char val) {
            this.val = val;
            isLast = false;
            children = new HashMap();
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