package exercise4;



import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {

        // TODO Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>(BUCKET_ARRAY_SIZE);
        for(int i=0;i<BUCKET_ARRAY_SIZE;i++){
            buckets.add(new LinkedList<MyEntry>());
        }
    }


    public String get(String key) {
        // TODO


        for(LinkedList<MyEntry> m:buckets){
            for(MyEntry my:m){
                if(my.getKey().equals(key)){
                    return my.getValue();
                }
            }
        }

        return null;
    }

    public void put(String key, String value) {
        // TODO
//        MyEntry myentry= new MyEntry(key,value);

        if(key != null) {
            if (!containsKey(key))
                buckets.get(Math.abs(key.hashCode() % 16)).add(new MyEntry(key, value));
        }
        else

            buckets.get(0).add(new MyEntry(key,value));

    }

//    public void resize(){
//        int size = buckets.size();
//        int i ;
//        ArrayList<LinkedList<MyEntry>> newbuckets = new ArrayList<LinkedList<MyEntry>>(size);
//        for(LinkedList<MyEntry> m:buckets){
//            i = 0;
//            for(MyEntry o:m) {
//                newbuckets.get(i).add(o);
//                i++;
//            }
//        }
//        buckets = new ArrayList<LinkedList<MyEntry>>(size*2);
//        for(LinkedList<MyEntry> m:newbuckets){
//            for(i = 0; i<m.size();i++) {
//                buckets.get(m.get(i).getKey().hashCode() % 16).add(m.get(i));
//            }
//        }
//    }

    public Set<String> keySet() {
        // TODO
        Set<String> keyset = new HashSet<String>();
        for(LinkedList<MyEntry> m : buckets){
            for(MyEntry n:m){
                keyset.add(n.getKey());
            }
        }

        return keyset;
    }

    public Collection<String> values() {
        // TODO

        Collection<String> colval = new ArrayList<String>();

        for(LinkedList<MyEntry> m : buckets){
            for(MyEntry n:m){
                colval.add(n.getValue());
            }
        }

        return colval;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        String str = null;
        for(LinkedList<MyEntry> m : buckets){
            for(MyEntry n:m){
                if(n.getKey().equals(key)) {
                    str = n.getValue();
                    m.remove(n);
                }
            }
        }
        return str;
    }

    public boolean containsKey(String key) {
        // TODO

        for(LinkedList<MyEntry> m : buckets){
            for(MyEntry n:m){
                if(n.getKey().equals(key))
                    return true;
            }
        }

        return false;
    }

    public boolean containsValue(String value) {
        // TODO

        for(LinkedList<MyEntry> m : buckets){
            for(MyEntry n:m){
                if(n.getValue().equals(value))
                    return true;
            }
        }

        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        int i = 0;
        for(LinkedList<MyEntry> m : buckets){
            for(MyEntry n:m){
                i++;
            }
        }

        return i;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        for(LinkedList<MyEntry> m : buckets){
            for(MyEntry n : m) {
                remove(n.getKey());
            }
        }
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects

        Set<MyEntry> myset = null;
        for(LinkedList<MyEntry> m : buckets){
            for(MyEntry n:m){
                myset.add(n);
            }
        }

        return null;
    }

    public boolean isEmpty() {
        // TODO
        return this.size()==0;
//        for(LinkedList<MyEntry> m : buckets){
//            if(m.get(0)!=null){
//                return false;
//            }
//        }

    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
