package Datastructs.SimpleList;

class SimpleListNode<K> {
    
    protected K elem;
    protected SimpleListNode<K> next;
    
    /**
     * Constructor
     * @param elem What the node contains
     */
    public SimpleListNode(K elem) {
        this.elem = elem;
        this.next = null;
    }
    
    /**
     * Constructor with the element and the next one.
     * @param elem First element
     * @param next Next element
     */
    public SimpleListNode(K elem, SimpleListNode<K> next) {
        this.elem = elem;
        this.next = next;
    }
    
    /**
     * Sets the element next to the current one 
     * @param next
     */
    public void setNext(SimpleListNode<K> next) {
        this.next = next;
    }

    /**
     * gets the value of the next node
     * @return next value
     */
    public SimpleListNode<K> getNext() {
        return this.next;
    }
    
    /**
     * gets the current value
     * @return Node value
     */
    public K getElem() {
        return this.elem;
    }
}
