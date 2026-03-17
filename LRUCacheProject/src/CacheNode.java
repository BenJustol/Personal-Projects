/**
 * Cache Node to store individual value and key for LRU system. Utilizes DoublyLL for faster access to next node and prev node.
 */

 class CacheNode {
    int key;
    int val;
    CacheNode next;
    CacheNode prev;

    /**
     * Standard parameterized constructor to set the key and val of a CacheNode
     */
    CacheNode(int k, int v)
    {
        key = k;
        val = v;
    }

}
