package com.hashtable;

import java.util.Arrays;
import java.util.Iterator;

import com.linkedlist.DoublyLinkedList;

public class HashTable<K, V> implements HashTableADT<K, V> {
	private static final int DEFAULT_CAPACITY = 10;
	private int size = 0, capacity;

	private DoublyLinkedList<Node<K, V>>[] table;

	public HashTable() {
		this.capacity = DEFAULT_CAPACITY;
		table = new DoublyLinkedList[capacity];
	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int hash(int key) {
		return key % capacity;
	}

	@Override
	public void clear() {
		Arrays.fill(table, null);
		size = 0;

	}

	@Override
	public boolean has(K key) {
		int index = hash(key.hashCode());
		DoublyLinkedList<Node<K, V>> linkedList = table[index];
		if (linkedList == null || linkedList.isEmpty())
			return false;
		for (Node<K, V> node : linkedList) {
			if (node.getKey().equals(key))
				return true;
		}
		return false;

	}

	@Override
	public V insert(K key, V value) {
		int index = hash(key.hashCode());
		DoublyLinkedList<Node<K, V>> linkedList = table[index];
		if (linkedList == null) {
			table[index] = linkedList = new DoublyLinkedList(); // create list
			linkedList.addLast(new Node<K, V>(key, value)); // add node to list
			size++;
			return value;
		}
		for (Node<K, V> node : table[index]) {
			if (node.getKey().equals(key)) {
				// key already exist in linkedlist
				// so we update the node
				node.setValue(value);
				return value;
			}
		}
		// node doesnt exist in list
		linkedList.addLast(new Node<K, V>(key, value)); // add new node to list
		size++;
		return value;
	}

	@Override
	public V get(K key) {
		int index = hash(key.hashCode());
		DoublyLinkedList<Node<K, V>> linkedList = table[index];
		if (linkedList == null || linkedList.isEmpty())
			return null;
		for (Node<K, V> node : linkedList) {
			if (node.getKey().equals(key))
				return node.getValue();
		}

		return null;
	}

	@Override
	public V remove(K key) {
		int index = hash(key.hashCode());
		DoublyLinkedList<Node<K, V>> linkedList = table[index];
		if (linkedList == null || linkedList.isEmpty())
			return null;
		for (Node<K, V> node : linkedList) {
			if (node.getKey().equals(key)) {
				 linkedList.remove(node);
				 --size;
				 return node.getValue();
			}
		}
		return null;
	}
	

	@Override
	public Iterator<K> iterator() {
		return null;
	}
		
}
