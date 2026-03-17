import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private HashMap<Integer, CacheNode> map;

    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int aCapacity)
    {
        this.capacity = aCapacity;
        map = new HashMap<>();
    }

    private void remove(CacheNode Node)
    {
        if (Node.prev != null)
        {
            Node.prev.next = Node.next;
        }
        else
        {
            head = Node.next;
        }

        if (Node.next != null)
        {
            Node.next.prev = Node.prev;
        }
        else
        {
            tail = Node.prev;
        }
    }

    private void insertFront(CacheNode node)
    {
        node.next = head;
        node.prev = null;

        if (head != null)
        {
            head.prev = node;
        }
        head = node;
        if (tail == null)
        {
            tail = head;
        }
    }

    public int get(int key)
    {
        if (!map.containsKey(key))
        {
            return -1;
        }
        CacheNode node = map.get(key);
        remove(node);
        insertFront(node);

        return node.val;
    }

    public void put(int aKey, int aVal)
    {
        if (map.containsKey(aKey))
        {
            CacheNode node = map.get(aKey);
            node.val = aVal;

            remove(node);
            insertFront(node);
            return;
        }

        CacheNode node = new CacheNode(aKey, aVal);
        if (map.size() == capacity)
        {
            map.remove(tail.key);
            remove(tail);
        }

        insertFront(node);
        map.put(aKey, node);
    }

    public void print()
    {
        CacheNode iter = head;

        while (iter != null)
        {
            System.out.print(iter.key + ":" + iter.val + " ");
            iter = iter.next;
        }

        System.out.println();
    }

}
