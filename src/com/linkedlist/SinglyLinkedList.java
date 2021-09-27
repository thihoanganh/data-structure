package com.linkedlist;

import java.util.Iterator;

import com.model.SinglyNode;

public class SinglyLinkedList<T> implements Iterable<T> {
	private int size = 0;
	private SinglyNode<T> head, tail = null;

	public void clear() {
		SinglyNode<T> currentNode = head;
		while (currentNode != null) {
			SinglyNode<T> nextNode = currentNode.getNext();
			currentNode.setData(null);
			currentNode.setNext(null);
			currentNode = nextNode;
		}
		head = tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void addFirst(T ele) {
		SinglyNode<T> newNode = new SinglyNode<T>(ele, head);
		head = newNode;
		size++;
	}

	public void addLast(T ele) {
		SinglyNode<T> newNode = new SinglyNode<T>(ele, null);
		if(size()==0) { // empty linked list
			head = tail = newNode;
		}else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
		
	}

	public T peekFirst() {
		return head.getData();
	}

	public T peekLast() {
		return tail.getData();
	}

	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty linked list!");
		T data = head.getData();
		if (size() == 1) {
			head.setData(null);
			head.setNext(null);
			head = tail = null;
		} else {
			head = head.getNext();
		}
		size--;
		return data;
	}

	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("Empty linked list!");
		T data = tail.getData();
		SinglyNode<T> secondLastNode = head;
		while (secondLastNode.getNext().getNext() != null) {
			secondLastNode = secondLastNode.getNext();
		}

		secondLastNode.setNext(null);
		tail = secondLastNode;
		size--;
		return data;
	}

	public T remove(SinglyNode<T> node) {
		if (isEmpty())
			throw new RuntimeException("Empty linked list");
		SinglyNode<T> currentNode = head;
		SinglyNode<T> prevNode = null;

		while (currentNode != null) {
			if (currentNode.getData().equals(node.getData())) {
				// remove
				prevNode.setNext(node.getNext());
				return currentNode.getData();
			}
			currentNode = currentNode.getNext();
			prevNode = currentNode;
		}
		return null;
	}

	public boolean remove(Object obj) {
		if (obj.equals(null)) {
			SinglyNode<T> currentNode = head;
			while (currentNode != null) {
				if (currentNode.getData() == null) {
					remove(currentNode);
					return true;
				}
			}
		} else {
			SinglyNode<T> currentNode = head;
			while (currentNode != null) {
				if (currentNode.getData().equals(obj)) {
					remove(currentNode);
					return true;
				}
			}
		}
		return false;
	}

	public int indexOf(Object obj) {
		SinglyNode<T> currentNode = head;
		int index = 0;
		while (currentNode != null) {
			if (currentNode.getData().equals(obj)) {
				return index;
			}
			index++;
			currentNode = currentNode.getNext();
		}
		return -1;
	}

	public T removeAt(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		SinglyNode<T> currentNode = head;
		int i = 0;
		while (currentNode != null) {
			if (index == i) {
				remove(currentNode);
				return currentNode.getData();
			}
			currentNode = currentNode.getNext();
		}
		return null;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private SinglyNode<T> currentNode = head;
			private boolean isFirstTimeTraverse = true;
			@Override
			public boolean hasNext() {
				if(isFirstTimeTraverse) {
					return currentNode != null;
				}else {
					return currentNode.getNext() != null;
				}
			}

			@Override
			public T next() {
				T data = null;
				if(isFirstTimeTraverse) {
					isFirstTimeTraverse = false;
					data = currentNode.getData();
				}else {
					currentNode = currentNode.getNext();
					data = currentNode.getData();
				}
				return data;
			}
		};
	}

}
