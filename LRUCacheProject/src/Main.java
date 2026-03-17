public class Main {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);

        cache.print();

        cache.get(1);

        cache.print();

        cache.put(4, 40);

        cache.print();
    }
}