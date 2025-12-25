class MyHashMap {
    private class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key =key;
            this.value = value;
        }
    }
    private static final int DEFAULT_CAPACITY = 1000;
    private Node [] buckets;

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
    }
    private int hash(int key){
        return key % DEFAULT_CAPACITY;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Node cur = buckets[hash];
        if(buckets[hash] == null){
            buckets[hash] = new Node(key, value);
            return;
        }
        while(true){
            if(cur.key == key){
                cur.value = value;
                return;
            }
            if(cur.next == null) break;
            cur = cur.next;
        }
        cur.next = new Node(key, value);
    }

    public int get(int key) {
        int hash = hash(key);
        Node cur = buckets[hash];
        if(buckets[hash] == null){
            return -1;
        }
        while(cur != null){
            if(cur.key == key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Node cur = buckets[hash];
        while (cur == null) return;
        if(cur.key == key){
            buckets[hash] = cur.next;
            return;
        }
        while(cur.next != null){
            if(cur.key == key){
                cur.next = cur.next.next;
                return;
            }
        }
    }
}