package com.linkedlist;

import java.util.Iterator;

import com.model.Node;

public class DoublyLinkedList<T> implements Iterable<T> {
	private int size;
	private Node<T> head = null;
	private Node<T> tail = null;

	public void clear() {
		Node<T> currentNode = head;
		while (currentNode != null) {
			Node<T> nextNode = currentNode.getNext();
			currentNode.setData(null);
			currentNode.setNext(null);
			currentNode.setPrev(null);
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
		if (isEmpty()) {
			head = tail = new Node<T>(ele, null, null);
		} else {
			head.setPrev(new Node<T>(ele, null, head));
			head = head.getPrev();
		}
		size++;
	}

	public void addLast(T ele) {
		if (isEmpty()) {
			head = tail = new Node<T>(ele, null, null);
		} else {
			tail.setNext(new Node<T>(ele, tail, null));
			tail = tail.getNext();
		}
		size++;
	}

	public T peekFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty linked list!");
		return head.getData();
	}

	public T peekLast() {
		if (isEmpty())
			throw new RuntimeException("Empty linked list!");
		return tail.getData();
	}

	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty linked list!");
		T data = head.getData();
		head = head.getNext();
		size--;
		if (isEmpty())
			tail = null;
		else
			head.setPrev(null);
		return data;
	}

	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("Empty linked list!");
		T data = tail.getData();
		tail = tail.getPrev();
		size--;
		if (isEmpty())
			head = null;
		else
			tail.setNext(null);
		return data;
	}

	public T remove(Node<T> node) {
		if (node.getNext() == null)
			removeLast(); // it's tail node
		if (node.getPrev() == null)
			removeFirst(); // it's head node

		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());

		T data = node.getData();
		size--;

		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
		node = null;

		return data;
	}

	public boolean remove(Object obj) {
		Node<T> currentNode = head;
		if (obj == null) {
			while (currentNode != null) {
				if (currentNode.getData() == null) {
					remove(currentNode);
					return true;
				}
				currentNode = currentNode.getNext();
			}
		} else {
			while (currentNode != null) {
				if (currentNode.getData().equals(obj)) {
					remove(currentNode);
					return true;
				}
				currentNode = currentNode.getNext();
			}
		}
		return false;
	}

	public T remove(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException();
		Node<T> currentNode = null;
		if (index < size / 2) { // size/2 as pivot for traversing
			int i = 0;
			currentNode = head;
			while (i != index) {
				currentNode = currentNode.getNext();
				i++;
			}
		} else {
			currentNode = head;
			int i = size - 1;
			while (i != index) {
				currentNode = currentNode.getNext();
				i--;
			}
		}
		return remove(currentNode);
	}

	public int indexOf(Object obj) {
		int index = 0;
		if (obj == null) {
			Node<T> currentNode = head;
			while (currentNode != null) {
				if (currentNode.getData() == null)
					return index;
				currentNode = currentNode.getNext();
				index++;
			}
		} else {
			Node<T> currentNode = head;
			while (currentNode != null) {
				if (currentNode.getData() == obj)
					return index;
				currentNode = currentNode.getNext();
				index++;
			}
		}

		return -1;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> currentNode = head;
			private boolean isFirstTimeTravase = true;

			@Override
			public boolean hasNext() {
				if (isFirstTimeTravase)
					return head != null;
				else
					return currentNode.getNext() != null;
			}

			@Override
			public T next() {
				T data = null;
				if (isFirstTimeTravase) {
					isFirstTimeTravase = false;
					data = head.getData();
				} else {
					currentNode = currentNode.getNext();
					data = currentNode.getData();
				}
				return data;
			}

		};
	}
}
