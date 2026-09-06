/**
 * 
 */
package HashTable;

import java.util.Map.Entry;

/**
 * 
 */
class HashTableImpl<K, V> {

	    private final EntryData<K, V>[] data;
	    
	    private static class EntryData<K,V>{
	    	
	    	 K key;
	         V value;

	         EntryData(K key, V value) {
	             this.key = key;
	             this.value = value;
	         } 
	    	
	    }

	    HashTableImpl(int size) {
	        this.data = new EntryData[size];
	    }

	    private int hash(K key) {
	        return Math.abs(key.hashCode()) % data.length;
	    }
	    
	    public void set(K key, V value) {
	    	EntryData<K, V> en = new EntryData<K, V>(key,value);
	    	data[hash(key)] = en;
	    	System.out.println("key stored at " +hash(key));
	    }
	    
	    public V get(K key) {
	    	EntryData<K, V> en =data[hash(key)];
	    	return en.value;
	    }
	    
	    public static void main(String[] args) {
	    	HashTableImpl<String,Integer> hash = new HashTableImpl<String,Integer>(50);
	    	hash.set("girls",1000);
	    	System.out.println(hash.get("girls"));
	    	
	    }

		
	}