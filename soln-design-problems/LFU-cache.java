/*
https://leetcode.com/problems/lfu-cache/
*/

/*
https://leetcode.com/problems/lfu-cache/
*/

class Node {
    int key;
    int value;
    int frequency;
    int tick;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LFUCache {
    int tick;
    int size;
    TreeSet<Node> set;
    HashMap<Integer, Node> map;
    
    public LFUCache(int capacity) {
        tick = 0;
        size = capacity;
        map = new HashMap<>();
        set = new TreeSet<>((a, b) -> a.frequency == b.frequency ? b.tick - a.tick : b.frequency - a.frequency);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) 
            return -1;
        Node cur_node = map.get(key);
        setUpdate(cur_node);
        map.put(key, cur_node);
        return cur_node.value;
    }
    
    public void put(int key, int value) {
        if(size == 0) 
            return;
        Node cur_node = map.get(key);
        if(cur_node != null) {
            cur_node.value = value;
            setUpdate(cur_node);
        } 
        else {
            if(map.size() == size) {
                Node last_node = set.pollLast();
                map.remove(last_node.key);
            }
            cur_node = new Node(key, value);
            setUpdate(cur_node);
        }
        map.put(key, cur_node);
    }
    
    // remove node in treeSet and put it into treeSet again, update its reference in hashMap
    private void setUpdate(Node node) {
        set.remove(node);
        node.frequency += 1;
        node.tick = ++tick;
        set.add(node);
    }  
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */