package com.queue;

import java.util.Iterator;

import com.linkedlist.DoublyLinkedList;

public class QueueBasedLinkedList<T> implements QueueADT<T> {
	private DoublyLinkedList<T> list = new DoublyLinkedList<T>();
	
	public QueueBasedLinkedList() {
	}
	
	@Override
	public void enQueue(T element) {
		list.addLast(element);
	}

	@Override
	public T deQueue() {
		if(isEmpty()) throw new RuntimeException("Queue empty");
		return list.removeFirst();
	}

	@Override
	public T peek() {
		if(isEmpty()) throw new RuntimeException("Queue empty");
		return list.peekFirst();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
	
	 

}
