public class LRUCache {
    public class cacheNode {
        int key;
        int val;
        
        public cacheNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Map <Integer, cacheNode> cache;
    private LinkedList <cacheNode> list;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<> ();
        list = new LinkedList<> ();
    }
    
    public int get(int key) {
        cacheNode node = cache.get(key);
        if (node != null) {
            list.remove(node);
            list.addFirst(node);
            return node.val;
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        cacheNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            list.remove(node);
            list.addFirst(node);
        } else {
            node = new cacheNode(key, value);
            if (cache.size() >= capacity) {
                cacheNode nodeToRemove = list.removeLast();
                cache.remove(nodeToRemove.key);
            }
            cache.put(key, node);
            list.addFirst(node);
        }
    }
}
