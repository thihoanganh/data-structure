package com.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

import com.linkedlist.SinglyLinkedList;

public class StackBasedLinkedList<T> implements StackADT<T> {
	private SinglyLinkedList<T> list = new SinglyLinkedList<T>();

	public StackBasedLinkedList() {
	}

	@Override
	public void push(T element) {
		list.addLast(element);
	}

	@Override
	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();
		return list.removeLast();
	}

	@Override
	public T top() {
		if (isEmpty())
			throw new EmptyStackException();
		return list.peekLast();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			 
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
