package simple;


import java.util.*;

/**
 * Created by Black on 07.09.2018.
 */
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.get(1);
        MineHashMap<Object,Object> a = new MineHashMap();
        a.put("O",3);
        a.put(0,2);
        a.put(10,"EE");
        System.out.println(a.get("O"));
        System.out.println(a.get(0));
        System.out.println(a.get(10));
    }

    static class MineHashMap<V,T>{
        final int DEFAULT_CAPACITY = 10;
        int capacity;
        int h;
        ArrayList<ArrayList> arrayList = new ArrayList<>(DEFAULT_CAPACITY);
        V key;
        T Value;

        MineHashMap() {
            capacity = DEFAULT_CAPACITY;
            for (int i = 0; i < capacity; i++) {
                arrayList.add(new ArrayList<Node>());
            }
        }

        public void put(V key, T value) {
            if (key == null) {
                putForNullKey(value);
            } else {
                h = Objects.hash(key);
                putForHashCode(h%capacity,key, value);
            }
        }

        private void putForHashCode(int cell, V key, T value) {
            Node node = new Node<>(key, value);
            ArrayList table = arrayList.get(cell);
            if(table.size()==0) {
                table.add(node);
            } else {
                for (Object nodeInArray: table) {
                    if (node.equals(nodeInArray)) {
                        return;
                    }
                }
                ((Node) table.get(table.size()-1)).next = node;
                table.add(node);
            }
            return;
        }

        private void putForNullKey(T value) {
            putForHashCode(0,null,value);
        }

        public T get(V key) {
            h = Objects.hash(key);
            ArrayList<Node> mapEntry = arrayList.get(h%capacity);
            if(mapEntry==null || mapEntry.size()==0) {
                return null;
            } else {
                Node node = mapEntry.get(0);
                if(node.key.equals(key)) {
                    return (T) node.value;
                } else {
                    while(node.next!=null) {
                        node = node.next;
                        if (node.key.equals(key)) {
                            return (T) node.value;
                        }
                    }
                    return null;
                }
            }
        }

        static class Node <V,T> {
            public V key;
            public T value;
            public Node next;

            Node(V key, T value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }

            @Override
            public boolean equals(Object obj) {
                Node node = (Node) obj;
                if (!node.key.equals(this.key))
                    return false;
                else if (!node.value.equals(this.value)){
                    return false;
                }
                return true;
            }
        }
    }

}
