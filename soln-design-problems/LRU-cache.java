/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/lru-cache/
*/

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value, Node next, Node prev){
        this.key=key;
        this.value=value;
        this.next=next;
        this.prev=prev;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    Node head=new Node(-1,-1,null,null);
    Node tail=new Node(-1,-1,null,null);
    int capacity;


    public LRUCache(int capacity) {
        map=new HashMap(capacity);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node cur_node=map.get(key);
            removeNode(cur_node);
            addNode(cur_node);
            return cur_node.value;
            
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node newNode=new Node(key,value,null,null);
        
        if(map.containsKey(key)){
            Node node=map.get(key);
            removeNode(node);
        }
        else{
            if(map.size()==this.capacity){
                Node node=map.remove(tail.prev.key);
                removeNode(node);
            }
        }
        
        addNode(newNode);
        map.put(key,newNode);
    }
    
    public void removeNode(Node node){
        Node prev_node=node.prev;
        Node next_node=node.next;
        
        prev_node.next=next_node;
        next_node.prev=prev_node;

    }
    
    public void addNode(Node node){
        Node head_next=head.next;
        node.next=head_next;
        head_next.prev=node;
        head.next=node;
        node.prev=head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
