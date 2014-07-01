public class LRUCache {
    public class cacheNode {
        int key;
        int val;
        cacheNode prev;
        cacheNode next;
        
        public cacheNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Map <Integer, cacheNode> cache;
    private cacheNode head, tail; //dummy nodes
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<> ();
        head = new cacheNode(0, 0);
        tail = new cacheNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        cacheNode node = cache.get(key);
        if (node != null) {
            remove(node);
            addFirst(node);
            return node.val;
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        cacheNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            addFirst(node);
        } else {
            node = new cacheNode(key, value);
            if (cache.size() >= capacity) {
                cacheNode nodeToRemove = removeLast();
                if (nodeToRemove != null) {
                    cache.remove(nodeToRemove.key);
                }
            }
            cache.put(key, node);
            addFirst(node);
        }
    }
    
    private void remove(cacheNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = node.prev = null;
    }
    
    private void addFirst(cacheNode node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }
    
    private cacheNode removeLast() {
        if (tail.prev == head) {
            return null;
        }
        cacheNode node = tail.prev;
        tail.prev = node.prev;
        tail.prev.next = tail;
        
        return node;
    }
}
