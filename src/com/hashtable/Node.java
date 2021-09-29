package com.hashtable;

public class Node<K, V> {
	private int hash;
	private K key;
	private V value;

	public Node(K key, V value) {
		this.hash = key.hashCode();
		this.key = key;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object other) {
		if(this.getHash() != ((Node<K,V>)other).getHash()) return false;
		return this.key.equals(((Node<K,V>)other).key);
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
}
